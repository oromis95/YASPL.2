package Files;

import visitors.Visitor;

import java.util.List;

public class FunctionCall extends Statement {
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

    @Override
    public String getRealName() {
        return "CallOp";
    }

    public Identifier getFunctionName() {
        return this.subTree(Identifier.class);
    }

    public List<Expression> getExpressions() {
        return this.subTrees(Expression.class);
    }

    public List<Identifier> getIdentifierList() {
        return this.subTrees(Identifier.class);
    }

}
