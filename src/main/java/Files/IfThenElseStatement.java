package Files;

import visitors.Visitor;

public class IfThenElseStatement extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "IfThenElseOp";
    }
    public BooleanExpression getIfCondition() {
        return this.subTree(BooleanExpression.class);
    }

    public Statement getThenStatement() {
        return this.subTree(Statement.class);
    }

    public Statement getElseStatement() {
        return this.subTree(Statement.class);
    }
}
