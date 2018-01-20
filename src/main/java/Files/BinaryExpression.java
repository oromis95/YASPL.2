package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 *A Tree node for the Binary Expression. For example:
 */
public class BinaryExpression extends Expression {
    private final Expression leftOperand;
    private final Expression rightOperand;
    private final String op;

    public BinaryExpression(Expression leftOperand, Expression rightOperand, String op) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.op = op;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public String getOp() {
        return op;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
