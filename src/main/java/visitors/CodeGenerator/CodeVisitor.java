package visitors.CodeGenerator;

import visitors.Visitor;
import visitors.syntax.nodes.*;

/**
 * @author Domenico Antonio Tropeano on 26/01/2018 at 10:45
 * @project yaspl
 */
public class CodeVisitor implements Visitor<String,String> {
    @Override
    public String visit(Program programNode, String optParam) {
        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclarationNode, String optParam) {
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclarationNode, String optParam) {
        return null;
    }

    @Override
    public String visit(Variable variableNode, String optParam) {
        return null;
    }

    @Override
    public String visit(Type typeNode, String optParam) {
        return null;
    }

    @Override
    public String visit(Identifier identifierNode, String optParam) {
        return null;
    }

    @Override
    public String visit(ParameterDeclaration parameterDeclarationNode, String optParam) {
        return null;
    }

    @Override
    public String visit(Body bodyNode, String optParam) {
        return null;
    }

    @Override
    public String visit(ReadStatement readStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(WriteStatement writeStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(FunctionCall functionCallNode, String optParam) {
        return null;
    }

    @Override
    public String visit(CompositeStatement compositeStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(WhileStatement whileStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(IfThenStatement ifThenStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(IfThenElseStatement ifThenElseStatementNode, String optParam) {
        return null;
    }

    @Override
    public String visit(BinaryExpression binaryExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(UminusExpression uminusExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(DoubleConst doubleConstNode, String optParam) {
        return null;
    }

    @Override
    public String visit(IntegerConst integerConstNode, String optParam) {
        return null;
    }

    @Override
    public String visit(StringConst stringConstNode, String optParam) {
        return null;
    }

    @Override
    public String visit(NotExpression notExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(TrueExpression trueExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(FalseExpression falseExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(RelationalExpression relationalExpressionNode, String optParam) {
        return null;
    }

    @Override
    public String visit(AssignStatement assignStatementNode, String optParam) {
        return null;
    }
}
