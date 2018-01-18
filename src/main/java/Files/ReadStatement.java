package Files;

import visitors.Visitor;

import java.util.List;

public class ReadStatement extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "ReadOp";
    }
    public List<Identifier> getIdentifierList() {
        return this.subTrees(Identifier.class);
    }

    public List<Type> getTypeList() {
        return this.subTrees(Type.class);
    }
}
