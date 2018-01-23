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
    private boolean isFunction = false;

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

}
