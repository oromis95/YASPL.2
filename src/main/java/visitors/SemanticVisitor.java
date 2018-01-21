package visitors;

import Files.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Domenico Antonio Tropeano on 21/01/2018 at 14:52
 * @project yaspl
 */
public class SemanticVisitor implements Visitor<Element, Void> {
    private Document xmlDocument;


    @Override
    public Element visit(Program programNode, Void optParam) {
        Element el = this.xmlDocument.createElement("ProgramOp");
        programNode.getDeclarations().forEach(d -> el.appendChild(d.accept(this, optParam)));
        programNode.getDeclarations().forEach(d -> el.appendChild(d.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(VariableDeclaration variableDeclarationNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(FunctionDeclaration functionDeclarationNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(Variable variableNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(Type typeNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(Identifier identifierNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(ParameterDeclaration parameterDeclarationNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(Body bodyNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(ReadStatement readStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(WriteStatement writeStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(FunctionCall functionCallNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(CompositeStatement compositeStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(WhileStatement whileStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(IfThenStatement ifThenStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(IfThenElseStatement ifThenElseStatementNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(BinaryExpression binaryExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(UminusExpression uminusExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(DoubleConst doubleConstNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(IntegerConst integerConstNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(StringConst stringConstNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(NotExpression notExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(TrueExpression trueExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(FalseExpression falseExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(RelationalExpression relationalExpressionNode, Void optParam) {
        return null;
    }

    @Override
    public Element visit(AssignStatement assignStatementNode, Void optParam) {
        return null;
    }
}
