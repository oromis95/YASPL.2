package Files;

import visitors.Visitor;

import java.util.List;

public class ParameterDeclaration extends CodeTree {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }

    @Override
    public String getRealName() {
        return "ParDeclOp";
    }
    public List<VariableDeclaration> getVariableDeclarationList() {
        return this.subTrees(VariableDeclaration.class);
    }

    public Identifier getIdentifier() {
        return this.subTree(Identifier.class);
    }
}
