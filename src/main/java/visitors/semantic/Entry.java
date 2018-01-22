package visitors.semantic;

import java_cup.runtime.ComplexSymbolFactory;

import java.util.ArrayList;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 13:38
 * @project yaspl
 */
public class Entry {
    private String name="null";
    private String type="null";
    private ArrayList<ComplexSymbolFactory.Location> locX;
    private ArrayList<ComplexSymbolFactory.Location> locY;
    private int dimension = -1;

    public Entry(String name, String type, ArrayList<ComplexSymbolFactory.Location> locX, ArrayList<ComplexSymbolFactory.Location> locY, String value) {
        this.name = name;
        this.type = type;
        this.locX = locX;
        this.locY = locY;
    }

    public Entry(ComplexSymbolFactory.ComplexSymbol cs) {
        locX=new ArrayList<>();
        locY=new ArrayList<>();
        locX.add(cs.getLeft());
        locY.add(cs.getRight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ArrayList<ComplexSymbolFactory.Location> getLocX() {
        return locX;
    }

    public void setLocX(ArrayList<ComplexSymbolFactory.Location> locX) {
        this.locX = locX;
    }

    public ArrayList<ComplexSymbolFactory.Location> getLocY() {
        return locY;
    }

    public void setLocY(ArrayList<ComplexSymbolFactory.Location> locY) {
        this.locY = locY;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public boolean isFunction() {
        if (this.dimension == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", locX=" + locX +
                ", locY=" + locY +
                ", dimension=" + dimension +
                '}';
    }
}
