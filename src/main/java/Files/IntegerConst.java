package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the IntegerConst
 */
public class IntegerConst extends Expression {
    private final int intValue;

    public IntegerConst(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);

    }

}
