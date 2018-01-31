package visitors.nodes;

import visitors.Visitor;

import java.util.List;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the FunctionDeclaration or Def_Decl
 */
public class FunctionDeclaration extends Decl {
    private final Identifier identifier;
    private final List<VariableDeclaration> variableDeclarations;
    private final List<ParameterDeclaration> parameterDeclarations;
    private final Body body;

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



    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }
}
