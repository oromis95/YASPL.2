package visitors;

public interface Visitable {
    String accept(IVisitor v);
}
