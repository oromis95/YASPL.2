package visitors.syntax.nodes;

import visitors.Visitor;

import java.util.List;

/**
 * @author - Tropeano Domenico Antonio on 20/01/2018
 * A Tree node for the Body
 */
public class Body extends CodeTree {
    private final List<VariableDeclaration> variableDeclarations;
    private final List<Statement> statements;

    public Body(List<VariableDeclaration> variableDeclarations, List<Statement> statements) {
        this.variableDeclarations = variableDeclarations;
        this.statements = statements;
    }

    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
