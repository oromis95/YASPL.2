package visitors.syntax.nodes;

import visitors.Visitor;

/**
 *@author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the Type
 */
public class Type extends CodeTree {
    private final String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this,param);
    }
}
