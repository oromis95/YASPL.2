package Files;

import visitors.Visitor;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * abstract for generate the YASPL2 Tree
 */
public abstract class CodeTree {

    public abstract <T, P> T accept(Visitor<T, P> visitor, P param);

}
