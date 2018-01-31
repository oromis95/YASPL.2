package visitors.nodes;

import visitors.semantic.exception.ScopeException;
import visitors.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the Program
 */
public class Program extends CodeTree {
    private HashMap<String, CodeTree> tableofSymbols;
    private final List<Decl> declarations;
    private final List<Statement> statements;

    public Program(List<Decl> declarations, List<Statement> statements) {
        this.declarations = declarations;
        this.statements = statements;
        tableofSymbols = new HashMap<>();
    }

    public List<Decl> getDeclarations() {
        return declarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void addToTos(String id, CodeTree Node) throws ScopeException {
        if (tableofSymbols.put(id, Node) != null)
            throw new ScopeException(id);

    }

    public CodeTree lookup(String id) {
        return tableofSymbols.get(id);
    }

    public void printTOS() {
        for (Map.Entry<String, CodeTree> entry : tableofSymbols.entrySet()) {
            System.out.println(entry);
        }
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
