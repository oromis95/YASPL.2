package visitors;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VisitableNode<T> extends ArrayMultiTreeNode<T> implements Visitable{
    public VisitableNode(T data) {
        super(data);
    }

    @Override
    public String accept(IVisitor v) {
        return v.visit(this);
    }

    @Override
    public Collection<? extends TreeNode<T>> subtrees() {
        if(isLeaf()){
            return Collections.emptySet();
        }
        Collection<TreeNode<T>> subtrees =new ArrayList<>(childsNum());
        for(int i=0;i<childsNum();i++){
            TreeNode<T> subtree= getChild(i);
            subtrees.add(subtree);
        }
        return subtrees;
    }

    public VisitableNode<T> getChild(int i){
        return getChild(i);
    }
    public int childsNum(){
        return childsNum();
    }
}
