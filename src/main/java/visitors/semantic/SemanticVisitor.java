package visitors.semantic;

import visitors.Visitor;
import visitors.lexical.EntryLexem;
import visitors.lexical.StringTable;
import visitors.semantic.exception.*;
import visitors.syntax.Entry;
import visitors.syntax.nodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 15:46
 * @project yaspl
 */
public class SemanticVisitor implements Visitor<EntrySymbol, EntrySymbol> {
    private Stack<SymbolTable> stackOfTable;
    public static StringTable stringTable;
    private static final String emp = "";

    public SemanticVisitor(StringTable stringTable) {
        this.stackOfTable = new Stack<>();
        this.stringTable = stringTable;
    }

    public SemanticVisitor() {
        this.stackOfTable = new Stack<>();
    }

    @Override
    public EntrySymbol visit(Program programNode, EntrySymbol optParam) {
        stackOfTable.add(new SymbolTable());
        programNode.getDeclarations().forEach(d -> d.accept(this, optParam));
        programNode.getStatements().forEach(s -> s.accept(this, optParam));
        return null;
    }

    @Override
    public EntrySymbol visit(VariableDeclaration variableDeclarationNode, EntrySymbol optParam) {
        int count = 0;
        if (optParam != null && optParam.isParameter()) {

            for (Variable v : variableDeclarationNode.getVariables()) {
                count++;
                optParam = new EntrySymbol();
                optParam = v.accept(this, optParam);
                if (stackOfTable.peek().containsKey(optParam.getName())) {
                    try {
                        throw new VariableNotDeclaredException("Parameter not found in function");
                    } catch (VariableNotDeclaredException e) {
                        System.out.println("Parameter not found in function");
                    }
                }
            }

        } else {
            for (Variable v : variableDeclarationNode.getVariables()) {
                optParam = new EntrySymbol();
                optParam.setType(variableDeclarationNode.getType().getTypeName());
                optParam = v.accept(this, optParam);
                optParam.setLocX(stringTable.get(optParam.getName()).getLocX());
                optParam.setLocY(stringTable.get(optParam.getName()).getLocY());
                checkAlreadyDeclared(optParam);
                count++;
            }
        }
        EntrySymbol needle = new EntrySymbol();
        needle.setDim(count);
        return needle;
    }

    @Override
    public EntrySymbol visit(FunctionDeclaration functionDeclarationNode, EntrySymbol optParam) {
        String id = functionDeclarationNode.getIdentifier().getName();
        EntrySymbol function = new EntrySymbol();
        if (stackOfTable.peek().containsKey(id)) {
            try {
                throw new FunctionAlreadyDeclaredException("Already Declared");
            } catch (FunctionAlreadyDeclaredException functionAlreadyDeclaredException) {
                functionAlreadyDeclaredException.printStackTrace();
            }
        } else {
            function.setName(id);
            function.setType(Constants.FUNCTION);
            function.setFunction();
            stackOfTable.push(new SymbolTable());
            for (VariableDeclaration vd : functionDeclarationNode.getVariableDeclarations()) {
                function.addVariableType(vd.getType().getTypeName());
                vd.accept(this, optParam);
            }
            for (ParameterDeclaration pd : functionDeclarationNode.getParameterDeclarations()) {
                function = pd.accept(this, function);
            }
            stackOfTable.firstElement().put(function.getName(), function);
            functionDeclarationNode.getBody().accept(this, optParam);
        }
        stackOfTable.pop();
        return null;
    }

    @Override
    public EntrySymbol visit(Variable variableNode, EntrySymbol optParam) {
        optParam = variableNode.getIdentifier().accept(this, optParam);
        return optParam;
    }

    @Override
    public EntrySymbol visit(Type typeNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(Identifier identifierNode, EntrySymbol optParam) {
       /* if(optParam==null){
            optParam=new EntrySymbol();
        }*/
        optParam.setName(identifierNode.getName());
        EntryLexem el = stringTable.get(identifierNode.getName());
        optParam.setLocX(el.getLocX());
        optParam.setLocY(el.getLocY());
        return optParam;
    }

    @Override
    public EntrySymbol visit(ParameterDeclaration parameterDeclarationNode, EntrySymbol optParam) {
        EntrySymbol variable = new EntrySymbol();
        for (VariableDeclaration vd : parameterDeclarationNode.getVariableDeclarations()) {
            optParam.addParameterType(vd.getType().getTypeName());
            variable.setType(vd.getType().getTypeName());
            variable.setParameter(true);
            int count = vd.accept(this, variable).getDim();
            for (int i = 1; i < count; i++) {
                optParam.addParameterType(vd.getType().getTypeName());
            }
        }
        return optParam;
    }


    @Override
    public EntrySymbol visit(Body bodyNode, EntrySymbol optParam) {
        bodyNode.getVariableDeclarations().forEach(vd -> vd.accept(this, optParam));
        bodyNode.getStatements().forEach(s -> s.accept(this, optParam));
        return null;
    }

    @Override
    public EntrySymbol visit(ReadStatement readStatementNode, EntrySymbol optParam) {
        List<String> types = new ArrayList<>();
        List<String> typesOfConstants = new ArrayList<>();
        for (Type t : readStatementNode.getTypes()) {
            types.add(t.getTypeName());
        }
        for (Variable v : readStatementNode.getVariables()) {
            if (stackOfTable.peek().containsKey(v.getIdentifier().getName())) {

                typesOfConstants.add(stackOfTable.peek().get(v.getIdentifier().getName()).getType());
            } else {
                try {
                    throw new VariableNotDeclaredException(v.getIdentifier().getName() + " not declared yet");
                } catch (VariableNotDeclaredException e) {
                    e.printStackTrace();
                }
            }
            continue;
        }
        if (types.equals(typesOfConstants)) {

        } else {
            try {
                throw new TypeMismatchException("Types Mismatch");
            } catch (TypeMismatchException e) {
                System.out.println("Types Mismatch");
            }
        }
        return null;
    }

    @Override
    public EntrySymbol visit(WriteStatement writeStatementNode, EntrySymbol optParam) {
        writeStatementNode.getExpression().forEach(e -> e.accept(this, optParam));
        return null;
    }

    @Override
    public EntrySymbol visit(FunctionCall functionCallNode, EntrySymbol optParam) {
        ArrayList<String> exprType = new ArrayList<>();
        ArrayList<String> varsType = new ArrayList<>();
        EntrySymbol choosedFunction = null;
        if (optParam == null) {
            optParam = new EntrySymbol();
        }
        if (stackOfTable.firstElement().containsKey(functionCallNode.getIdentifier().getName())) {
            choosedFunction = stackOfTable.firstElement().get(functionCallNode.getIdentifier().getName());
        } else {
            try {
                throw new FunctionNotDeclaredException(functionCallNode.getIdentifier().getName());
            } catch (FunctionNotDeclaredException e) {
                e.printStackTrace();
            }
        }

        for (Expression exp : functionCallNode.getExpressions()) {
            optParam = exp.accept(this, optParam);
            exprType.add(optParam.getType());
            if (exprType.equals(choosedFunction.getVariableArrayFirm())) {
                //Variables Match
            } else {
                try {
                    throw new TypeMismatchException("Variables mismatch with function firm");
                } catch (TypeMismatchException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Variable v : functionCallNode.getVariables()) {
            optParam = v.accept(this, optParam);
            optParam=stackOfTable.peek().get(optParam.getName());
            varsType.add(optParam.getType());
            if (varsType.equals(choosedFunction.getParameterArrayFirm())) {
                //Parameter Match
            } else {
                try {
                    throw new TypeMismatchException("Parameter mismatch with function firm \n"
                    +"Expected "+ choosedFunction.getParameterArrayFirm()+" getted "+ varsType);
                } catch (TypeMismatchException e) {
                    System.out.println("Parameter mismatch with function firm \n"
                            +"Expected "+ choosedFunction.getParameterArrayFirm()+" getted "+ varsType);
                }
            }
        }
        return null;//CONTROLLARE SE FINITO
    }

    @Override
    public EntrySymbol visit(CompositeStatement compositeStatementNode, EntrySymbol optParam) {
        compositeStatementNode.getStatements().forEach(s -> s.accept(this, optParam));
        return null;
    }

    @Override
    public EntrySymbol visit(WhileStatement whileStatementNode, EntrySymbol optParam) {
        whileStatementNode.getBooleanExpression().accept(this, optParam);
        whileStatementNode.getWhileStatement().accept(this, optParam);
        return null;
    }

    @Override
    public EntrySymbol visit(IfThenStatement ifThenStatementNode, EntrySymbol optParam) {
        ifThenStatementNode.getIfCondition().accept(this, optParam);
        ifThenStatementNode.getThenStatement().accept(this, optParam);
        return null;
    }

    @Override
    public EntrySymbol visit(IfThenElseStatement ifThenElseStatementNode, EntrySymbol optParam) {
        ifThenElseStatementNode.getIfCondition().accept(this, optParam);
        ifThenElseStatementNode.getThenStatement().accept(this, optParam);
        ifThenElseStatementNode.getElseStatement().accept(this, optParam);
        return null;
    }

    @Override
    public EntrySymbol visit(BinaryExpression binaryExpressionNode, EntrySymbol optParam) {
        String leftType = "";
        String rightType = "";
        EntrySymbol es = new EntrySymbol();
        EntrySymbol leftS, rightS;
        optParam = new EntrySymbol();
        leftS = binaryExpressionNode.getLeftOperand().accept(this, optParam);
        rightS = binaryExpressionNode.getRightOperand().accept(this, optParam);
        if (leftS == null || leftS.getType() == null) {
            String id = binaryExpressionNode.getLeftOperand().accept(this, optParam).getName();
            leftType = stackOfTable.peek().get(id).getType();
        }
        if (rightS == null || leftS.getType() == null) {
            String id = binaryExpressionNode.getRightOperand().accept(this, optParam).getName();
            boolean a = checkIsExestingInScope(id);
            rightType = stackOfTable.peek().get(id).getType();
        }

        if (rightType.equals(leftType)) {
            es.setType(rightType);
        } else if ((rightType.equals(Constants.DOUBLE) || rightType.equals(Constants.INTEGER)) &&
                leftType.equals(Constants.DOUBLE) || leftType.equals(Constants.INTEGER)) {
            es.setType(Constants.DOUBLE);
        } else {
            try {
                throw new TypeMismatchException("(Binary Expression)Operation denied with this types ");
            } catch (TypeMismatchException e) {
                e.printStackTrace();
            }
        }
        return es;
    }

    @Override
    public EntrySymbol visit(UminusExpression uminusExpressionNode, EntrySymbol optParam) {
        optParam = uminusExpressionNode.getExpression().accept(this, optParam);
        return optParam;
    }

    @Override
    public EntrySymbol visit(DoubleConst doubleConstNode, EntrySymbol optParam) {
        optParam = new EntrySymbol();
        optParam.setType(Constants.DOUBLE);
        return optParam;
    }

    @Override
    public EntrySymbol visit(IntegerConst integerConstNode, EntrySymbol optParam) {
        optParam = new EntrySymbol();
        optParam.setType(Constants.INTEGER);
        return optParam;
    }

    @Override
    public EntrySymbol visit(StringConst stringConstNode, EntrySymbol optParam) {
        optParam = new EntrySymbol();
        optParam.setType(Constants.STRING);
        return optParam;
    }

    @Override
    public EntrySymbol visit(NotExpression notExpressionNode, EntrySymbol optParam) {
        return notExpressionNode.getExpression().accept(this, optParam);
    }

    @Override
    public EntrySymbol visit(TrueExpression trueExpressionNode, EntrySymbol optParam) {
        optParam = new EntrySymbol();
        optParam.setType(Constants.BOOL);
        return optParam;
    }

    @Override
    public EntrySymbol visit(FalseExpression falseExpressionNode, EntrySymbol optParam) {
        optParam = new EntrySymbol();
        optParam.setType(Constants.STRING);
        return optParam;
    }

    @Override
    public EntrySymbol visit(RelationalExpression relationalExpressionNode, EntrySymbol optParam) {
        String leftType = "";
        String rightType = "";
        if (optParam != null) {
        } else {
            optParam = new EntrySymbol();
        }
        leftType = relationalExpressionNode.getLeftOperand().accept(this, optParam).getType();
        if (leftType == null) {
            String id = relationalExpressionNode.getLeftOperand().accept(this, optParam).getName();
            leftType = stackOfTable.peek().get(id).getType();
        }
        rightType = relationalExpressionNode.getRightOperand().accept(this, optParam).getType();
        if (rightType == null) {
            String id = relationalExpressionNode.getRightOperand().accept(this, optParam).getName();
            rightType = stackOfTable.peek().get(id).getType();
        }
        if (rightType.equals(leftType)) {

        } else if ((rightType.equals(Constants.DOUBLE) || rightType.equals(Constants.INTEGER)) &&
                leftType.equals(Constants.DOUBLE) || leftType.equals(Constants.INTEGER)) {

        } else {
            try {
                throw new TypeMismatchException("(RelationalExpression)Operation denied with this types ");
            } catch (TypeMismatchException e) {
                System.out.println("(RelationalExpression)Operation denied with this types " + leftType + " " + rightType);
            }
        }
        EntrySymbol es = new EntrySymbol();
        es.setType(Constants.BOOL);
        return es;
    }

    @Override
    public EntrySymbol visit(AssignStatement assignStatementNode, EntrySymbol optParam) {
        EntrySymbol currEntry = stackOfTable.peek().get(assignStatementNode.getIdentifier().getName());
        String type = assignStatementNode.getExpression().accept(this, optParam).getType();
        if (currEntry.getType().equals(type)) {

        } else if (currEntry.getType().equals(Constants.DOUBLE) && type.equals(Constants.INTEGER)) {

        } else {
            try {
                throw new TypeMismatchException("Type Mismatch in assign statement");
            } catch (TypeMismatchException e) {
                System.out.println("Type Mismatch in assign statement");
            }
        }
        return null;
    }

    private void checkAlreadyDeclared(EntrySymbol variable) {
        if (stackOfTable.peek().containsKey(variable.getName())) {
            try {
                throw new VariableAlreadyDeclared(variable.getName() + " already declared in these scope "
                        + variable.getLocX() + " " + variable.getLocY());
            } catch (VariableAlreadyDeclared variableAlreadyDeclared) {
                System.out.println(variable.getName() + " already declared in these scope "
                        + variable.getLocX() + " " + variable.getLocY());
            }
        } else if (stackOfTable.firstElement().containsKey(variable.getName())) {
            try {
                throw new VariableAlreadyDeclared(variable.getName() + " already declared in global scope "
                        + variable.getLocX() + " " + variable.getLocY());
            } catch (VariableAlreadyDeclared variableAlreadyDeclared) {
                System.out.println(variable.getName() + " already declared in global scope "
                        + variable.getLocX() + " " + variable.getLocY());
            }
        } else {
            stackOfTable.peek().put(variable.getName(), variable);
        }
    }

    public boolean checkIsExestingInScope(String id) {
        if (stackOfTable.peek().containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsExistingGlobal(String id) {
        if (stackOfTable.firstElement().containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

}
