package Files;

import visitors.Visitor;

import java.util.List;

public class CompositeStatement extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "CompStatOp";
    }

    public List<Statement> getStatementList() {
        return this.subTrees(Statement.class);
    }
}
