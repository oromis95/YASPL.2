package Files;

import visitors.Visitor;

public class Variable extends CodeTree {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "VarOp";
    }

    public Identifier getIdentifier() {
        return this.subTree(Identifier.class);
    }
}
