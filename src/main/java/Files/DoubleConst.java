package Files;

import visitors.Visitor;

public class DoubleConst extends Expression {
    private final double doubleValue;

    public DoubleConst(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }
}
