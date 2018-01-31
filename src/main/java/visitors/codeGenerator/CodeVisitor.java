package visitors.codeGenerator;

import visitors.Visitor;
import visitors.nodes.*;
import visitors.semantic.Constants;
import visitors.semantic.EntrySymbol;
import visitors.semantic.SymbolTable;

import java.util.Stack;

/**
 * @author Domenico Antonio Tropeano on 26/01/2018 at 10:45
 * @project yaspl
 */
public class CodeVisitor implements Visitor<String, String> {
    private String output = "";
    private static final String EMPTYFORPROTO = "[---]";
    private static final String UNKNOWN = "[___]";
    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String NEWLINE = "\n";
    private static final String VOID = "void";
    private static final String LEFTRBRA = "(";
    private static final String RIGHTRBRA = ")";
    private static final String LEFTCBRA = "{";
    private static final String RIGHTCBRA = "}";
    private static final String STAR = "*";
    private static final String RETURN = "return";
    private static final String DO = "do";
    private static final String WHILE = "while";
    private static final String IF = "if";
    private static final String ELSE = "else";
    private static final String MINUS = "-";
    private static final String DOUBLEQUOTE = "\"";
    private Stack<SymbolTable> stackOfTable;

    public CodeVisitor(Stack<SymbolTable> stackOfTable) {
        this.stackOfTable = stackOfTable;
    }

    private static String removeLastChar(String str) {
        if (str != "") {
            return str.substring(0, str.length() - 1);
        } else {
            return str;
        }
    }

    @Override
    public String visit(Program programNode, String optParam) {
        optParam += "#include<stdio.h>" +
                NEWLINE + "#include <stdbool.h>" + NEWLINE + EMPTYFORPROTO + NEWLINE;
        //Collections.reverse(programNode.getDeclarations());
        //Collections.reverse(programNode.getStatements());
        for (Decl d : programNode.getDeclarations()) {
            optParam = d.accept(this, optParam);
        }
        optParam = optParam.replace(EMPTYFORPROTO + NEWLINE, "");
        optParam += NEWLINE + "int main" + LEFTRBRA + RIGHTRBRA + LEFTCBRA;
        for (Statement s : programNode.getStatements()) {
            optParam = s.accept(this, optParam);
        }
        optParam += "return 0" + SEMICOLON + RIGHTCBRA;
        return optParam;
    }

    @Override
    public String visit(VariableDeclaration variableDeclarationNode, String optParam) {
        //Collections.reverse(variableDeclarationNode.getVariables());
        if (variableDeclarationNode.getType().equals(Constants.STRING)) {
            optParam += "char" + SPACE;
            for (Variable v : variableDeclarationNode.getVariables()) {
                optParam = v.accept(this, optParam);
                optParam += "[500]" + COMMA;
            }
        } else {
            optParam += variableDeclarationNode.getType().getTypeName() + SPACE;
            for (Variable v : variableDeclarationNode.getVariables()) {
                optParam = v.accept(this, optParam);
                optParam += COMMA;
            }
        }

        optParam = removeLastChar(optParam);
        optParam += SEMICOLON + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclarationNode, String optParam) {
        //Collections.reverse(functionDeclarationNode.getVariableDeclarations());
        //Collections.reverse(functionDeclarationNode.getParameterDeclarations());
        String functionID = functionDeclarationNode.getIdentifier().getName();
        EntrySymbol function = stackOfTable.firstElement().get(functionID);
        String proto = "";
        String temp = "";
        proto += VOID + SPACE + functionID + LEFTRBRA;
        for (String var : function.getVariableArrayFirm()) {
            proto += var + COMMA;
        }
        for (String var : function.getParameterArrayFirm()) {
            proto += var + STAR + COMMA;
        }
        proto = removeLastChar(proto);
        proto += RIGHTRBRA + SEMICOLON + NEWLINE;
        optParam = optParam.replace(EMPTYFORPROTO, proto + EMPTYFORPROTO);
        optParam += VOID + SPACE + functionID + LEFTRBRA;
        for (VariableDeclaration vd : functionDeclarationNode.getVariableDeclarations()) {
            temp = vd.accept(this, temp);
            temp = removeLastChar(temp);
            temp = removeLastChar(temp);
            temp = temp.replace(COMMA, COMMA + vd.getType().getTypeName() + SPACE);
            temp = temp.replace(vd.getType().getTypeName(), vd.getType().getTypeName());
        }
        optParam += temp;
        SymbolTable table = stackOfTable.firstElement().get(functionID).getInsideScope();
        if (temp != "") {
            temp = COMMA;
        }
        for (ParameterDeclaration pm : functionDeclarationNode.getParameterDeclarations()) {
            for (VariableDeclaration vd : pm.getVariableDeclarations()) {
                temp = vd.accept(this, temp);
                temp = removeLastChar(temp);
                temp = removeLastChar(temp);
                temp += "OUT" + COMMA;
                temp = temp.replace(vd.getType().getTypeName() + SPACE, vd.getType().getTypeName() + STAR + SPACE);
            }
        }
        temp = removeLastChar(temp);
        optParam += temp + RIGHTRBRA + NEWLINE + LEFTCBRA + NEWLINE;
        stackOfTable.push(table);
        optParam = functionDeclarationNode.getBody().accept(this, optParam);
        stackOfTable.pop();
        for (ParameterDeclaration pm : functionDeclarationNode.getParameterDeclarations()) {
            for (VariableDeclaration vd : pm.getVariableDeclarations()) {
                for (Variable v : vd.getVariables()) {
                    String forReturn = "";
                    forReturn = v.getIdentifier().getName();
                    forReturn = "*" + forReturn + "OUT=" + forReturn + SEMICOLON + NEWLINE;
                    optParam += forReturn;
                }
            }
        }
        optParam += NEWLINE + RIGHTCBRA + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(Variable variableNode, String optParam) {
        return optParam + variableNode.getIdentifier().getName();
    }

    @Override
    public String visit(Type typeNode, String optParam) {
        return optParam + typeNode.getTypeName();
    }

    @Override
    public String visit(Identifier identifierNode, String optParam) {
        return optParam + identifierNode.getName();
    }

    @Override
    public String visit(ParameterDeclaration parameterDeclarationNode, String optParam) {
        return "WEIRD";
    }

    @Override
    public String visit(Body bodyNode, String optParam) {
        //Collections.reverse(bodyNode.getVariableDeclarations());
        //Collections.reverse(bodyNode.getStatements());
        for (VariableDeclaration vd : bodyNode.getVariableDeclarations()) {
            optParam = vd.accept(this, optParam);
        }
        for (Statement s : bodyNode.getStatements()) {
            optParam = s.accept(this, optParam);
        }
        return optParam;
    }

    @Override
    public String visit(ReadStatement readStatementNode, String optParam) {
        //Collections.reverse(readStatementNode.getTypes());
        //Collections.reverse(readStatementNode.getVariables());
        String temp = "";
        for (Variable v : readStatementNode.getVariables()) {
            String thisType;
            if(checkIsExestingInScope(v.getIdentifier().getName())) {
                thisType= stackOfTable.peek().get(v.getIdentifier().getName()).getType();
            }else {
                thisType= stackOfTable.firstElement().get(v.getIdentifier().getName()).getType();
            }
            if (thisType.equals(Constants.INTEGER))
                temp = "scanf(\"%d\" ,&" + v.getIdentifier().getName() + ") ;";
            else if (thisType.equals(Constants.DOUBLE)) {
                temp = "scanf(\"%lf\" ,&" + v.getIdentifier().getName() + ") ;";
            } else if (thisType.equals(Constants.STRING)) {
                temp = "scanf(\"%s\" ,&" + v.getIdentifier().getName() + ") ;";
            } else if (thisType.equals(Constants.BOOL)) {
                temp = "scanf(\"%d\" ,&" + v.getIdentifier().getName() + ") ;";
            } else if (thisType.equals(Constants.FUNCTION)) {
                System.out.println("ERROR TYPE FUNCTION");
            } else {
                System.out.println("IMPOSSIBLE ERROR");
            }
            temp += NEWLINE;
        }
        optParam += temp + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(WriteStatement writeStatementNode, String optParam) {
        //Collections.reverse(writeStatementNode.getExpression());
        String temp = "";
        for (Expression e : writeStatementNode.getExpression()) {
            String content = e.accept(this, "");
            if (content.matches("-?\\d+")) {
                temp = "printf(\"%d\\n\"," + content + " ) ;";
            } else if (content.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                temp = "printf(\"%lf\\n\"," + content + ") ;";
            } else if (checkIsExestingInScope(content)) {
                String type = stackOfTable.peek().get(content).getType();
                temp = getStuffFromSymbolTable(temp, content, type);
            } else if (checkIsExistingGlobal(content)) {
                String type = stackOfTable.firstElement().get(content).getType();
                temp = getStuffFromSymbolTable(temp, content, type);
            } else {
                temp = "printf(\"" + content + "\\n\" );" + NEWLINE;
            }
        }
        optParam += temp;
        return optParam;
    }

    private String getStuffFromSymbolTable(String temp, String content, String type) {
        if (type.equals(Constants.INTEGER)) {
            temp = "printf(\"%d\\n\"," + content + ") ;";
        } else if (type.equals(Constants.DOUBLE)) {
            temp = "printf(\"%f\\n\"," + content + ") ;";
        } else if (type.equals(Constants.STRING)) {
            temp = "printf(\"%s\\n\"," + content + ") ;";
        } else {
            System.out.println("ERRORE DI STAMPA");
        }
        return temp;
    }

    @Override
    public String visit(FunctionCall functionCallNode, String optParam) {
        //Collections.reverse(functionCallNode.getVariables());
        //Collections.reverse(functionCallNode.getExpressions());
        String id = functionCallNode.getIdentifier().getName();
        String temp = "";
        for (Expression e : functionCallNode.getExpressions()) {
            temp = e.accept(this, temp) + COMMA;
        }
        for (Variable v : functionCallNode.getVariables()) {
            temp += "&" + v.getIdentifier().getName() + COMMA;
        }
        temp = removeLastChar(temp);
        return optParam + id + LEFTRBRA + temp + RIGHTRBRA + SEMICOLON + NEWLINE;

    }

    @Override
    public String visit(CompositeStatement compositeStatementNode, String optParam) {
        //Collections.reverse(compositeStatementNode.getStatements());
        for (Statement s : compositeStatementNode.getStatements()) {
            optParam = s.accept(this, optParam); //PROBABILE CAUSA DI ERRORI
        }
        return optParam;
    }

    @Override
    public String visit(WhileStatement whileStatementNode, String optParam) {
        optParam += WHILE + SPACE + LEFTRBRA;
        optParam = whileStatementNode.getBooleanExpression().accept(this, optParam);
        optParam += RIGHTRBRA + NEWLINE + LEFTCBRA + NEWLINE;
        optParam = whileStatementNode.getWhileStatement().accept(this, optParam);
        optParam += NEWLINE + RIGHTCBRA + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(IfThenStatement ifThenStatementNode, String optParam) {
        optParam += IF + LEFTRBRA;
        optParam = ifThenStatementNode.getIfCondition().accept(this, optParam);
        optParam += RIGHTRBRA + NEWLINE + LEFTCBRA;
        optParam = ifThenStatementNode.getThenStatement().accept(this, optParam);
        optParam += RIGHTCBRA + SPACE + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(IfThenElseStatement ifThenElseStatementNode, String optParam) {
        optParam += IF + LEFTRBRA;
        optParam = ifThenElseStatementNode.getIfCondition().accept(this, optParam);
        optParam += RIGHTRBRA + NEWLINE + LEFTCBRA;
        optParam = ifThenElseStatementNode.getThenStatement().accept(this, optParam);
        optParam += RIGHTCBRA + SPACE + ELSE + LEFTCBRA;
        optParam = ifThenElseStatementNode.getElseStatement().accept(this, optParam);
        optParam += RIGHTCBRA + SPACE + NEWLINE;
        return optParam;
    }

    @Override
    public String visit(BinaryExpression binaryExpressionNode, String optParam) {
        optParam = binaryExpressionNode.getLeftOperand().accept(this, optParam);
        optParam += giveCorrectSymbol(binaryExpressionNode.getOp());
        optParam = binaryExpressionNode.getRightOperand().accept(this, optParam);
        return optParam;
    }

    @Override
    public String visit(UminusExpression uminusExpressionNode, String optParam) {
        optParam += MINUS;
        optParam = uminusExpressionNode.getExpression().accept(this, optParam);
        return optParam;
    }

    @Override
    public String visit(DoubleConst doubleConstNode, String optParam) {
        return optParam + doubleConstNode.getDoubleValue();
    }

    @Override
    public String visit(IntegerConst integerConstNode, String optParam) {
        return optParam + integerConstNode.getIntValue();
    }

    @Override
    public String visit(StringConst stringConstNode, String optParam) {
        return optParam + stringConstNode.getStringValue();
    }

    @Override
    public String visit(NotExpression notExpressionNode, String optParam) {
        optParam += "!" + LEFTRBRA;
        optParam = notExpressionNode.getExpression().accept(this, optParam);
        optParam += RIGHTRBRA + SPACE;
        return optParam;
    }

    @Override
    public String visit(TrueExpression trueExpressionNode, String optParam) {
        return optParam + "true";
    }

    @Override
    public String visit(FalseExpression falseExpressionNode, String optParam) {
        return optParam + "false";
    }

    @Override
    public String visit(RelationalExpression relationalExpressionNode, String optParam) {
        optParam = relationalExpressionNode.getLeftOperand().accept(this, optParam);
        optParam += giveCorrectSymbol(relationalExpressionNode.getRelOp());
        optParam = relationalExpressionNode.getRightOperand().accept(this, optParam);
        return optParam;
    }

    @Override
    public String visit(AssignStatement assignStatementNode, String optParam) {
        optParam += assignStatementNode.getIdentifier().getName() + SPACE + "=" + SPACE;
        optParam = assignStatementNode.getExpression().accept(this, optParam);
        optParam += SEMICOLON + NEWLINE;
        return optParam;
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

    public String giveCorrectSymbol(String stuff) {
        switch (stuff) {
            case "DIV":
                return " / ";
            case "TIMES":
                return " * ";
            case "PLUS":
                return " + ";
            case "MINUS":
                return " - ";
            case "GT":
                return " > ";
            case "GE":
                return " >= ";
            case "LT":
                return " < ";
            case "LE":
                return " <= ";
            case "EQ":
                return " == ";

            default:
                return "ERRORRELOP";
        }
    }
}
