package Files;

import visitors.Visitor;

/**
 *@author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the an assignment
 */
public class AssignStatement extends Statement {
    private final Identifier identifier;
    private final Expression expression;

    public AssignStatement(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
