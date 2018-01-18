package Files;

import visitors.Visitor;

public class WhileStatement extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }

    @Override
    public String getRealName() {
        return "WhileOp";
    }
    public BooleanExpression getWhileCondition() {
        return this.subTree(BooleanExpression.class);
    }

    public Statement getWhileStatement() {
        return this.subTree(Statement.class);
    }
}
