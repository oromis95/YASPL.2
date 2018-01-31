package visitors.nodes;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the IfThenStatement
 */
public class IfThenStatement extends Statement {
private final BooleanExpression ifCondition;
private final CompositeStatement thenStatement;

    public IfThenStatement(BooleanExpression ifCondition, CompositeStatement thenStatement) {
        this.ifCondition = ifCondition;
        this.thenStatement = thenStatement;
    }

    public BooleanExpression getIfCondition() {
        return ifCondition;
    }

    public CompositeStatement getThenStatement() {
        return thenStatement;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }
}
