package Files;

import com.googlecode.jctree.ArrayListTree;
import com.googlecode.jctree.NodeNotFoundException;
import java_cup.runtime.ComplexSymbolFactory;
import visitors.Visitor;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CodeTree extends ArrayListTree<CodeTree>{
    public CodeTree() {
        super();
    }


    public CodeTree(ComplexSymbolFactory.ComplexSymbol symbol) {
        super();
    }

    public abstract <T, P> T accept(Visitor<T, P> visitor, P param); //Interface Visitable
    public abstract String getRealName();

    protected final <E> List<E> subTrees(Class<E> klass) {
        try {
            return this.children(this).stream().filter(klass::isInstance)
                    .map(klass::cast)
                    .collect(Collectors.toList());
        } catch (NodeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final <E> E subTree(Class<E> klass) {
        try {
            return this.children(this).stream().filter(klass::isInstance)
                    .findFirst().map(klass::cast).get();
        } catch (NodeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CodeTree> ownChildren() {
        try {
            return this.children(this);
        } catch (NodeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
