package visitors;

import visitors.syntax.nodes.*;

/**
 * Visitor interface based on Visitor Pattern
 *
 * @param <T> is the node that must be saved
 * @param <P> is an optional parameter
 */
public interface Visitor<T, P> {
    T visit(Program programNode, P optParam);

    T visit(VariableDeclaration variableDeclarationNode, P optParam);

    T visit(FunctionDeclaration functionDeclarationNode, P optParam);

    T visit(Variable variableNode, P optParam);

    T visit(Type typeNode, P optParam);

    T visit(Identifier identifierNode, P optParam);

    T visit(ParameterDeclaration parameterDeclarationNode, P optParam);

    T visit(Body bodyNode, P optParam);

    T visit(ReadStatement readStatementNode, P optParam);

    T visit(WriteStatement writeStatementNode, P optParam);

    T visit(FunctionCall functionCallNode, P optParam);

    T visit(CompositeStatement compositeStatementNode, P optParam);

    T visit(WhileStatement whileStatementNode, P optParam);

    T visit(IfThenStatement ifThenStatementNode, P optParam);

    T visit(IfThenElseStatement ifThenElseStatementNode, P optParam);

    T visit(BinaryExpression binaryExpressionNode, P optParam);

    T visit(UminusExpression uminusExpressionNode, P optParam);

    T visit(DoubleConst doubleConstNode, P optParam);

    T visit(IntegerConst integerConstNode, P optParam);

    T visit(StringConst stringConstNode, P optParam);

    T visit(NotExpression notExpressionNode, P optParam);

    T visit(TrueExpression trueExpressionNode, P optParam);

    T visit(FalseExpression falseExpressionNode, P optParam);

    T visit(RelationalExpression relationalExpressionNode, P optParam);

    T visit(AssignStatement assignStatementNode, P optParam);

}
