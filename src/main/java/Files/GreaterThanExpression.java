package Files;

import visitors.Visitor;

public class GreaterThanExpression extends RelationalExpression {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "GtOp";
    }
}
