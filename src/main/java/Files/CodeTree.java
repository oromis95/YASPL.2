package Files;

import visitors.Visitor;


public abstract class CodeTree {

    public abstract <T, P> T accept(Visitor<T, P> visitor, P param);

}
