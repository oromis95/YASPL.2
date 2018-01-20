package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the TrueExpression
 */
public class TrueExpression extends BooleanExpression {
    public TrueExpression() {
        super();
    }

    public boolean getValue() {
        return true;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }


}
