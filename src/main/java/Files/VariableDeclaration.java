package Files;

import visitors.Visitor;

import java.util.List;

public class VariableDeclaration extends CodeTree{
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "VarDeclOp";
    }

    public Type getType() {
        return this.subTree(Type.class);
    }

    public List<Variable> getVariables() {
        return this.subTrees(Variable.class);
    }
}
