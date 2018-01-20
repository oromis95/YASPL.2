package Files;

import visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ParameterDeclaration extends CodeTree {
    private final List<VariableDeclaration> variableDeclarations;

    public ParameterDeclaration(List<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

    public ParameterDeclaration(VariableDeclaration vd) {
        this.variableDeclarations = new ArrayList<>();
        this.variableDeclarations.add(vd);
    }

    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
