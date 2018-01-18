package Files;

import visitors.Visitor;

import java.util.List;

public class FunctionDeclaration extends CodeTree {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "ProcDeclOp";
    }

    public Identifier getIdentifier() {
        return this.subTree(Identifier.class);
    }

    public List<VariableDeclaration> getVariableDeclarationList() {
        return this.subTrees(VariableDeclaration.class);
    }

    public List<ParameterDeclaration> getParamenterDeclarationList() {
        return this.subTrees(ParameterDeclaration.class);
    }

    public Body getBody() {
        return this.subTree(Body.class);
    }
}
