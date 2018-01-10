package visitors;

public interface IVisitor<T> {
    String visit(VisitableNode<T> vn);
}
