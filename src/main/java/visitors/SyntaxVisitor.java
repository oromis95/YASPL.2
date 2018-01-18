package visitors;

import Files.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SyntaxVisitor implements Visitor<Element, Void> {
    private Document xmlDocument;

    @Override
    public Element visit(Program programNode, Void optionalParameter) {
        return null;
    }

    @Override
    public Element visit(VariableDeclaration variableDeclarationNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(FunctionDeclaration functionDeclarationNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(Variable variableNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(BooleanType booleanTypeNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(IntegerType integerTypeNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(StringType stringTypeNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(DoubleType doubleTypeNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(Identifier identifierNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(ParameterDeclaration parameterDeclarationNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(Body bodyNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(ReadStatement readStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(WriteStatement writeStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(FunctionCall functionCallNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(CompositeStatement compositeStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(WhileStatement whileStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(IfThenStatement ifThenStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(IfThenElseStatement ifThenElseStatementNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(SumExpression sumExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(DifferenceExpression differenceExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(ProductExpression productExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(DivideExpression divideExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(UminusExpression uminusExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(DoubleConst doubleConstNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(IntegerConst integerConstNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(StringConst stringConstNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(AndExpression andExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(OrExpression orExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(NotExpression notExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(TrueExpression trueExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(FalseExpression falseExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(GreaterThanExpression greatThanExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(GreaterThanEqualExpression greatThanEqualExpression, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(LessThanExpression lessThanExpression, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(LessThanEqualExpression lessThanEqualExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(EqualsExpression equalsExpressionNode, Void additionalParameter) {
        return null;
    }

    @Override
    public Element visit(AssignStatement assignStatementNode, Void additionalParameter) {
        return null;
    }
}