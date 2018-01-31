package visitors.nodes;

import visitors.Visitor;

import java.util.List;

/**
 *@author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the WriteStatement
 */
public class WriteStatement extends Statement {
private final List<Expression> expression;

    public WriteStatement(List<Expression> expression) {
        this.expression = expression;
    }

    public List<Expression> getExpression() {
        return expression;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
