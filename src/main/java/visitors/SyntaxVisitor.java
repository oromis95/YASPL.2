package visitors;

import Files.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Syntax Visitor for YASPL2 based on Visitor pattern
 */
public class SyntaxVisitor implements Visitor<Element, Void> {
    private Document xmlDocument;

    /**
     * Constructor and creator of XML-document
     */
    public SyntaxVisitor() {
        super();
        this.createDocument();
    }

    /**
     * Method to append the root of the tree
     * @param el is the root of the tree
     */
    public void appendRoot(Element el) {
        this.xmlDocument.appendChild(el);
    }

    /**
     * Method to create factory and builder for the XML-Document
     */
    public void createDocument() {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            this.xmlDocument = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to print the XML
     */
    public void toXml() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(this.xmlDocument);
            StreamResult result = new StreamResult(new File(System.getProperty("user.home").concat("\\output.xml")));
            transformer.transform(source, result);
            System.out.println("File saved!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Element visit(Program programNode, Void optParam) {
        Element el = this.xmlDocument.createElement("ProgramOp");
        programNode.getDeclarations().forEach(d -> el.appendChild(d.accept(this, optParam)));
        programNode.getDeclarations().forEach(d -> el.appendChild(d.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(VariableDeclaration variableDeclarationNode, Void optParam) {
        Element el = this.xmlDocument.createElement("VarDeclOp");
        el.appendChild(variableDeclarationNode.getType().accept(this, optParam));
        variableDeclarationNode.getVariables().forEach(v -> el.appendChild(v.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(FunctionDeclaration functionDeclarationNode, Void optParam) {
        Element el = this.xmlDocument.createElement("ProcDeclOp");
        el.setAttribute("name", functionDeclarationNode.getIdentifier().getName());
        functionDeclarationNode.getVariableDeclarations().forEach(v -> el.appendChild(v.accept(this, optParam)));
        functionDeclarationNode.getParameterDeclarations().forEach(p -> el.appendChild(p.accept(this, optParam)));
        el.appendChild(functionDeclarationNode.getBody().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(Variable variableNode, Void optParam) {
        Element el = this.xmlDocument.createElement("VarOp");
        el.appendChild(variableNode.getIdentifier().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(Type typeNode, Void optParam) {
        Element el = this.xmlDocument.createElement("Type");
        el.setAttribute("value", typeNode.getTypeName());
        return el;
    }

    @Override
    public Element visit(Identifier identifierNode, Void optParam) {
        Element el = this.xmlDocument.createElement("IdentifierOp");
        el.setAttribute("lexem", identifierNode.getName());
        return el;
    }

    @Override
    public Element visit(ParameterDeclaration parameterDeclarationNode, Void optParam) {
        Element el = this.xmlDocument.createElement("ParDeclOp");
        parameterDeclarationNode.getVariableDeclarations().forEach(v -> el.appendChild(v.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(Body bodyNode, Void optParam) {
        Element el = this.xmlDocument.createElement("BodyOp");
        bodyNode.getStatements().forEach(s -> el.appendChild(s.accept(this, optParam)));
        bodyNode.getVariableDeclarations().forEach(v -> el.appendChild(v.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(ReadStatement readStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("ReadOp");
        readStatementNode.getVariables().forEach(i -> el.appendChild(i.accept(this, optParam)));
        readStatementNode.getTypes().forEach(t -> el.appendChild(t.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(WriteStatement writeStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("WriteOp");
        writeStatementNode.getExpression().forEach(e -> el.appendChild(e.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(FunctionCall functionCallNode, Void optParam) {
        Element el = this.xmlDocument.createElement("CallOp");
        el.setAttribute("name", functionCallNode.getIdentifier().getName());
        functionCallNode.getExpressions().forEach(e -> el.appendChild(e.accept(this, optParam)));
        functionCallNode.getVariables().forEach(v -> el.appendChild(v.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(CompositeStatement compositeStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("CompStatOp");
        compositeStatementNode.getStatements().forEach(s -> el.appendChild(s.accept(this, optParam)));
        return el;
    }

    @Override
    public Element visit(WhileStatement whileStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("WhileOp");
        el.appendChild(whileStatementNode.getBooleanExpression().accept(this, optParam));
        el.appendChild(whileStatementNode.getWhileStatement().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(IfThenStatement ifThenStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("IfThenOp");
        el.appendChild(ifThenStatementNode.getIfCondition().accept(this, optParam));
        el.appendChild(ifThenStatementNode.getThenStatement().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(IfThenElseStatement ifThenElseStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("IfThenElseOp");
        el.appendChild(ifThenElseStatementNode.getIfCondition().accept(this, optParam));
        el.appendChild(ifThenElseStatementNode.getThenStatement().accept(this, optParam));
        el.appendChild(ifThenElseStatementNode.getElseStatement().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(BinaryExpression binaryExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("BinOp");
        el.setAttribute("operator", binaryExpressionNode.getOp());
        el.appendChild(binaryExpressionNode.getLeftOperand().accept(this, optParam));
        el.appendChild(binaryExpressionNode.getRightOperand().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(UminusExpression uminusExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("UMinusOp");
        el.appendChild(uminusExpressionNode.getExpression().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(DoubleConst doubleConstNode, Void optParam) {
        Element el = this.xmlDocument.createElement("DoubleConst");
        el.setAttribute("value", String.valueOf(doubleConstNode.getDoubleValue()));
        return el;
    }

    @Override
    public Element visit(IntegerConst integerConstNode, Void optParam) {
        Element el = this.xmlDocument.createElement("IntConst");
        el.setAttribute("value", String.valueOf(integerConstNode.getIntValue()));
        return el;
    }

    @Override
    public Element visit(StringConst stringConstNode, Void optParam) {
        Element el = this.xmlDocument.createElement("StringConst");
        el.setAttribute("value", String.valueOf(stringConstNode.getStringValue()));
        return el;
    }

    @Override
    public Element visit(NotExpression notExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("NotOp");
        el.appendChild(notExpressionNode.getExpression().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(TrueExpression trueExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("TrueConst");
        el.setAttribute("value", String.valueOf(trueExpressionNode.getValue()));
        return el;
    }

    @Override
    public Element visit(FalseExpression falseExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("FalseConst");
        el.setAttribute("value", String.valueOf(falseExpressionNode.getValue()));
        return el;
    }

    @Override
    public Element visit(RelationalExpression relationalExpressionNode, Void optParam) {
        Element el = this.xmlDocument.createElement("Relop");
        el.setAttribute("operator", relationalExpressionNode.getRelOp());
        el.appendChild(relationalExpressionNode.getLeftOperand().accept(this, optParam));
        el.appendChild(relationalExpressionNode.getRightOperand().accept(this, optParam));
        return el;
    }

    @Override
    public Element visit(AssignStatement assignStatementNode, Void optParam) {
        Element el = this.xmlDocument.createElement("AssignOp");
        el.appendChild(assignStatementNode.getIdentifier().accept(this, optParam));
        el.appendChild(assignStatementNode.getExpression().accept(this, optParam));
        return el;
    }
    /* */


}