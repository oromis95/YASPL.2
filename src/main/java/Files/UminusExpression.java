package Files;

import visitors.Visitor;

public class UminusExpression extends Expression {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return null;
    }

    @Override
    public String getRealName() {
        return null;
    }
}
