package Files;

import visitors.Visitor;

import java.util.List;

public class Body extends CodeTree {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "BodyOp";
    }
    public List<Statement> getStatements() {
        return this.subTrees(Statement.class);
    }
}
