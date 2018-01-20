package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the FalseExpression
 */
public class FalseExpression extends BooleanExpression {
    public FalseExpression() {
        super();
    }

    public boolean getValue() {
        return false;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
