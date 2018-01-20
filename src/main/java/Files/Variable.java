package Files;

import visitors.Visitor;

/**
 *@author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the Variable
 */
public class Variable extends CodeTree {
    private final Identifier identifier;

    public Variable(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
