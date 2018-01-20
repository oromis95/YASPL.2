package Files;

import visitors.Visitor;

public class StringConst extends Expression {
    private String stringValue;

    public StringConst(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }

}
