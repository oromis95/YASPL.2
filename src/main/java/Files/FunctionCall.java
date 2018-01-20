package Files;

import visitors.Visitor;

import java.util.List;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the FunctionCall
 */
public class FunctionCall extends Statement {
private final Identifier identifier;
private final List<Expression> expressions;
private final List<Variable> variables;

    public FunctionCall(Identifier identifier, List<Expression> expressions, List<Variable> variables) {
        this.identifier = identifier;
        this.expressions = expressions;
        this.variables = variables;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}