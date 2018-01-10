package visitors;

import java.util.HashMap;

public class SemanticElement {
    private String data;

    private String type;
    private boolean canHaveScope,canBeAdded;
    private HashMap<String,SemanticElement> tos;

    public SemanticElement(String data, String type) {
        this.data = data;
        this.type = type;
        this.canHaveScope=(this.data.equals(NodeConstants.PROGRAMMA));
    }
}
