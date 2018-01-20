package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the WhileStatement
 */
public class WhileStatement extends Statement {
    private final BooleanExpression booleanExpression;
    private final CompositeStatement whileStatement;

    public WhileStatement(BooleanExpression booleanExpression, CompositeStatement whileStatement) {
        this.booleanExpression = booleanExpression;
        this.whileStatement = whileStatement;
    }

    public BooleanExpression getBooleanExpression() {
        return booleanExpression;
    }

    public CompositeStatement getWhileStatement() {
        return whileStatement;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }
}
