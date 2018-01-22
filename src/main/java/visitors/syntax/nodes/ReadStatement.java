package visitors.syntax.nodes;

import visitors.Visitor;

import java.util.List;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the ReadStatement
 */
public class ReadStatement extends Statement {
private final List<Variable> variables;
private final List<Type> types;

    public ReadStatement(List<Variable> variables, List<Type> types) {
        this.variables = variables;
        this.types = types;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Type> getTypes() {
        return types;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
