package Files;

import visitors.Visitor;

public class AssignStatement extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "AssignOp";
    }

    public Identifier getIdentifier() {
        return this.subTree(Identifier.class);
    }

    public Expression getExpression() {
        return this.subTree(Expression.class);
    }
}
