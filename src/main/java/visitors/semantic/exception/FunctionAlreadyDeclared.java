package visitors.semantic.exception;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 22:07
 * @project yaspl
 */
public class FunctionAlreadyDeclared extends Exception {
    public FunctionAlreadyDeclared(String message) {
        super(message);
    }
}
