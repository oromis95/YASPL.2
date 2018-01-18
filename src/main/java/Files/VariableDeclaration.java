package Files;

import visitors.Visitor;

public class VariableDeclaration extends CodeTree{
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return null;
    }

    @Override
    public String getRealName() {
        return null;
    }
}
