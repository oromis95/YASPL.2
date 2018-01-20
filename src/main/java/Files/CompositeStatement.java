package Files;

import visitors.Visitor;

import java.util.List;

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
