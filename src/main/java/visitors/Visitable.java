package visitors;

public interface Visitable {
    String accept(Visitor v);
}
