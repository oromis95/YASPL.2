package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the StringConst
 */
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
