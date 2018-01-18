package Files;

import visitors.Visitor;

import java.util.List;

public class Program extends CodeTree {

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "ProgramOp";
    }

    public List<VariableDeclaration> getVariableDeclarations() {
        return this.subTrees(VariableDeclaration.class);
    }

    public List<FunctionDeclaration> getFunctionDeclarations() {
        return this.subTrees(FunctionDeclaration.class);
    }

}
