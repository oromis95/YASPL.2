package visitors.semantic;

import java_cup.runtime.ComplexSymbolFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 15:36
 * @project yaspl
 */
public class EntrySymbol {
    private String name;
    private String type;
    private ArrayList<ComplexSymbolFactory.Location> locX = new ArrayList<>();
    private ArrayList<ComplexSymbolFactory.Location> locY = new ArrayList<>();
    private ArrayList<String> variableArrayType;
    private ArrayList<String> parameterArrayType;
    private int dim = 0;
    private boolean isFunction = false;
    private boolean isParameter = false;
    private SymbolTable insideScope;

    public EntrySymbol() {
    }

    public EntrySymbol(String name, String type, ArrayList<ComplexSymbolFactory.Location> locX, ArrayList<ComplexSymbolFactory.Location> locY) {
        this.name = name;
        this.type = type;
        this.locX = locX;
        this.locY = locY;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<ComplexSymbolFactory.Location> getLocX() {
        return locX;
    }

    public ArrayList<ComplexSymbolFactory.Location> getLocY() {
        return locY;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocX(ArrayList<ComplexSymbolFactory.Location> locX) {
        this.locX = locX;
    }

    public void setLocY(ArrayList<ComplexSymbolFactory.Location> locY) {
        this.locY = locY;
    }

    public void setFunction() {
        this.variableArrayType = new ArrayList<>();
        this.parameterArrayType = new ArrayList<>();
        isFunction = true;
        insideScope = new SymbolTable();
    }

    public ArrayList<String> getVariableArrayFirm() {
        return variableArrayType;
    }

    public ArrayList<String> getParameterArrayFirm() {
        return parameterArrayType;
    }

    public void addVariableType(String type) {
        variableArrayType.add(type);
    }

    public void addParameterType(String type) {
        parameterArrayType.add(type);
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public boolean isParameter() {
        return isParameter;
    }

    public SymbolTable getInsideScope() {
        return insideScope;
    }

    public void setInsideScope(SymbolTable insideScope) {
        this.insideScope = insideScope;
    }

    @Override
    public String toString() {
        if (isFunction) {
            return "EntrySymbol{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", locX=" + locX +
                    ", locY=" + locY +
                    "is Function with " +
                    "variableList " + variableArrayType +
                    "parameterList " + parameterArrayType +
                    '}';
        } else {
            return "EntrySymbol{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", locX=" + locX +
                    ", locY=" + locY +
                    '}';
        }
    }

    public void setParameter(boolean value) {
        this.isParameter = value;
    }

}
