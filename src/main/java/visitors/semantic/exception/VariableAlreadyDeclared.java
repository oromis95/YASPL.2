package visitors.semantic.exception;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 20:02
 * @project yaspl
 */
public class VariableAlreadyDeclared extends Exception {

    public VariableAlreadyDeclared(String message) {
        super(message);
    }

}
