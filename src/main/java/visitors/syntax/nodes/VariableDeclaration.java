package visitors.syntax.nodes;

import visitors.Visitor;

import java.util.List;

/**
 *@author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the VariableDeclaration
 */
public class VariableDeclaration extends Decl {
    private final Type type;
    private final List<Variable> variables;


    public VariableDeclaration(Type type, List<Variable> variables) {
        this.type = type;
        this.variables = variables;

    }

    public Type getType() {
        return type;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
