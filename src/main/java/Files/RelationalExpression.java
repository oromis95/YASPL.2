package Files;


import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the RelationalExpression
 */
public class RelationalExpression extends BooleanExpression {
    private Expression leftOperand, rightOperand;
    private final String relOp;

    public RelationalExpression(Expression leftOperand, Expression rightOperand, String relOp) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.relOp = relOp;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public String getRelOp() {
        return relOp;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
