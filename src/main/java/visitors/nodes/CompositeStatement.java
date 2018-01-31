package visitors.nodes;

import visitors.Visitor;

import java.util.List;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the Composite Statement
 */
public class CompositeStatement extends Statement {
    private final List<Statement> statements;

    public CompositeStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
