package visitors;

import com.scalified.tree.TreeNode;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

public class SyntacticVisitor implements IVisitor<SemanticElement> {
    private String toWriteIntoFile;

    @Override
    public String visit(VisitableNode<SemanticElement> vn) {
        toWriteIntoFile=String.format("<%s>",vn.data().getData());
        Iterator<? extends TreeNode<SemanticElement>> childs;
        childs = vn.subtrees().iterator();

        while(childs.hasNext()){
            VisitableNode<SemanticElement> child=(VisitableNode<SemanticElement>)childs.next();

            if(!child.isLeaf())
                toWriteIntoFile+=child.accept(this);
            else{
                String data=child.data().getData();

                if(data.equals(Constants.INT)||data.equals(Constants.DOUBLE)||data.equals(Constants.BOOL))
                    toWriteIntoFile+=String.format("<%s/>",data);
                else
                    toWriteIntoFile+=data.replace(">","&gt").replace("<","lt");
            }
        }
        toWriteIntoFile+=String.format("</%s>",vn.data().getData());
        return toWriteIntoFile;
    }
    public void toFile() throws Exception {
        File outputFile = new File("tree.xml");

        if (!outputFile.exists())
            outputFile.createNewFile();

        PrintWriter writer = new PrintWriter(outputFile);

        writer.write(toWriteIntoFile);

        writer.close();
    }
}
