package visitors;

import Files.*;

public interface Visitor<T,P> {
    T visit(Program programNode, P optionalParameter);
    T visit(VariableDeclaration variableDeclarationNode, P optionalParameter);
    T visit(FunctionDeclaration functionDeclarationNode, P optionalParameter);
    T visit(Variable variableNode, P optionalParameter);
    T visit(BooleanType booleanTypeNode, P optionalParameter);
    T visit(IntegerType integerTypeNode, P optionalParameter);
    T visit(StringType stringTypeNode, P optionalParameter);
    T visit(DoubleType doubleTypeNode, P optionalParameter);
    T visit(Identifier identifierNode, P optionalParameter);
    T visit(ParameterDeclaration parameterDeclarationNode, P optionalParameter);
    T visit(Body bodyNode, P optionalParameter);
    T visit(ReadStatement readStatementNode, P optionalParameter);
    T visit(WriteStatement writeStatementNode, P optionalParameter);
    T visit(FunctionCall functionCallNode, P optionalParameter);
    T visit(CompositeStatement compositeStatementNode, P optionalParameter);
    T visit(WhileStatement whileStatementNode, P optionalParameter);
    T visit(IfThenStatement ifThenStatementNode, P optionalParameter);
    T visit(IfThenElseStatement ifThenElseStatementNode, P optionalParameter);
    T visit(SumExpression sumExpressionNode, P optionalParameter);
    T visit(DifferenceExpression differenceExpressionNode, P optionalParameter);
    T visit(ProductExpression productExpressionNode, P optionalParameter);
    T visit(DivideExpression divideExpressionNode, P optionalParameter);
    T visit(UminusExpression uminusExpressionNode, P optionalParameter);
    T visit(DoubleConst doubleConstNode, P optionalParameter);
    T visit(IntegerConst integerConstNode, P optionalParameter);
    T visit(StringConst stringConstNode, P optionalParameter);
    T visit(AndExpression andExpressionNode, P optionalParameter);
    T visit(OrExpression orExpressionNode, P optionalParameter);
    T visit(NotExpression notExpressionNode, P optionalParameter);
    T visit(TrueExpression trueExpressionNode, P optionalParameter);
    T visit(FalseExpression falseExpressionNode, P optionalParameter);
    T visit(GreaterThanExpression greatThanExpressionNode, P optionalParameter);
    T visit(GreaterThanEqualExpression greatThanEqualExpression, P optionalParameter);
    T visit(LessThanExpression lessThanExpression, P optionalParameter);
    T visit(LessThanEqualExpression lessThanEqualExpressionNode, P optionalParameter);
    T visit(EqualsExpression equalsExpressionNode, P optionalParameter);
    T visit(AssignStatement assignStatementNode, P optionalParameter);


}
