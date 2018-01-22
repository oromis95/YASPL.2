package visitors.semantic;

import visitors.Visitor;
import visitors.lexical.EntryLexem;
import visitors.lexical.StringTable;
import visitors.semantic.exception.FunctionAlreadyDeclared;
import visitors.semantic.exception.VariableAlreadyDeclared;
import visitors.syntax.nodes.*;

import java.util.Stack;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 15:46
 * @project yaspl
 */
public class SemanticVisitor implements Visitor<EntrySymbol, EntrySymbol> {
    private Stack<SymbolTable> stackOfTable;
    private StringTable stringTable;
    private static final String emp = "";

    public SemanticVisitor(StringTable stringTable) {
        this.stackOfTable = new Stack<>();
        this.stringTable = stringTable;
    }


    @Override
    public EntrySymbol visit(Program programNode, EntrySymbol optParam) {
        stackOfTable.add(new SymbolTable());
        programNode.getDeclarations().forEach(d -> d.accept(this, optParam));
        programNode.getStatements().forEach(s -> s.accept(this, optParam));
        return null;
    }

    @Override
    public EntrySymbol visit(VariableDeclaration variableDeclarationNode, EntrySymbol optParam) throws VariableAlreadyDeclared {
        optParam.setType(variableDeclarationNode.getType().getTypeName());
        optParam.setLocX(stringTable.get(optParam.getName()).getLocX());
        optParam.setLocY(stringTable.get(optParam.getName()).getLocY());
        for (Variable v : variableDeclarationNode.getVariables()) {
            optParam = v.accept(this, optParam);
            if (stackOfTable.peek().containsKey(optParam.getName())) {
                throw new VariableAlreadyDeclared("Already declared in these scope "
                        + optParam.getLocX() + " " + optParam.getLocY());
            } else if (stackOfTable.firstElement().containsKey(optParam.getName())) {
                throw new VariableAlreadyDeclared("Already declared in these scope "
                        + optParam.getLocX() + " " + optParam.getLocY());
            } else {
                stackOfTable.peek().put(optParam.getName(), optParam);
            }
        }
        return null;
    }

    @Override
    public EntrySymbol visit(FunctionDeclaration functionDeclarationNode, EntrySymbol optParam) throws FunctionAlreadyDeclared {
        String id = functionDeclarationNode.getIdentifier().getName();
        if (stackOfTable.peek().containsKey(id) &&
                stackOfTable.peek().get(id).getType().equals("func")) {
            //funzione già dichiarata
            throw new FunctionAlreadyDeclared("Already Declared");

        }
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
        optParam.setName(identifierNode.getName());
        EntryLexem el = stringTable.get(identifierNode.getName());
        optParam.setLocX(el.getLocX());
        optParam.setLocY(el.getLocY());
        return optParam;
    }

    @Override
    public EntrySymbol visit(ParameterDeclaration parameterDeclarationNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(Body bodyNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(ReadStatement readStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(WriteStatement writeStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(FunctionCall functionCallNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(CompositeStatement compositeStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(WhileStatement whileStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(IfThenStatement ifThenStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(IfThenElseStatement ifThenElseStatementNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(BinaryExpression binaryExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(UminusExpression uminusExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(DoubleConst doubleConstNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(IntegerConst integerConstNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(StringConst stringConstNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(NotExpression notExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(TrueExpression trueExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(FalseExpression falseExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(RelationalExpression relationalExpressionNode, EntrySymbol optParam) {
        return null;
    }

    @Override
    public EntrySymbol visit(AssignStatement assignStatementNode, EntrySymbol optParam) {
        return null;
    }
}
