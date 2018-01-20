package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the UminusExpression
 */
public class UminusExpression extends Expression {
private final Expression expression;

    public UminusExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
