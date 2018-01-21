package Files;

import exception.ScopeException;
import visitors.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the FunctionDeclaration or Def_Decl
 */
public class FunctionDeclaration extends Decl {
    private final Identifier identifier;
    private final List<VariableDeclaration> variableDeclarations;
    private final List<ParameterDeclaration> parameterDeclarations;
    private final Body body;
    private HashMap<String, CodeTree> tableofSymbols;

    public FunctionDeclaration(Identifier identifier, List<VariableDeclaration> variableDeclarations, List<ParameterDeclaration> parameterDeclarations, Body body) {
        this.identifier = identifier;
        this.variableDeclarations = variableDeclarations;
        this.parameterDeclarations = parameterDeclarations;
        this.body = body;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public List<ParameterDeclaration> getParameterDeclarations() {
        return parameterDeclarations;
    }

    public Body getBody() {
        return body;
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
