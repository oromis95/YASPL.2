package Files;

import visitors.Visitor;

import java.util.List;

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
