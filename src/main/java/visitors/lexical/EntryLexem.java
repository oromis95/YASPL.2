package visitors.lexical;


import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

import java.util.ArrayList;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 14:03
 * @project yaspl
 */
public class EntryLexem {
    private ArrayList<ComplexSymbolFactory.Location> locX;
    private ArrayList<ComplexSymbolFactory.Location> locY;
    private String code;

    public EntryLexem(ComplexSymbolFactory.ComplexSymbol cs) {
        locX = new ArrayList<>();
        locY = new ArrayList<>();
        locX.add(cs.getLeft());
        locY.add(cs.getRight());
        code = cs.getName();
    }

    public void addLocation(ComplexSymbolFactory.ComplexSymbol cs) {
        locX.add(cs.getLeft());
        locY.add(cs.getRight());
    }

    public ArrayList<ComplexSymbolFactory.Location> getLocX() {
        return locX;
    }

    public ArrayList<ComplexSymbolFactory.Location> getLocY() {
        return locY;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "EntryLexem{" +
                "locX=" + locX +
                ", locY=" + locY +
                ", code='" + code + '\'' +
                '}';
    }
}
