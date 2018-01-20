package Files;

import visitors.Visitor;

import java.util.List;

public class Program extends CodeTree {

    private final List<Decl> declarations;
    private final List<Statement> statements;

    public Program(List<Decl> declarations, List<Statement> statements) {
        this.declarations = declarations;
        this.statements = statements;
    }

    public List<Decl> getDeclarations() {
        return declarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P param) {
        return visitor.visit(this, param);
    }

}
