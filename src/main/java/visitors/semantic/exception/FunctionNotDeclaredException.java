package visitors.semantic.exception;

/**
 * @author Domenico Antonio Tropeano on 24/01/2018 at 11:29
 * @project yaspl
 */
public class FunctionNotDeclaredException extends Exception {
    public FunctionNotDeclaredException(String name) {
        super("La funzione " + name + " non è stata dichirata");
    }
}
