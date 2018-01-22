package visitors.semantic;

import java_cup.runtime.ComplexSymbolFactory;

import java.util.ArrayList;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 15:36
 * @project yaspl
 */
public class EntrySymbol {
    private String name;
    private String type;
    private ArrayList<ComplexSymbolFactory.Location> locX=new ArrayList<>();
    private ArrayList<ComplexSymbolFactory.Location> locY=new ArrayList<>();
    private int dimension = -1;


    public EntrySymbol() {
    }

    public EntrySymbol(String name, String type, ArrayList<ComplexSymbolFactory.Location> locX, ArrayList<ComplexSymbolFactory.Location> locY) {
        this.name = name;
        this.type = type;
        this.locX = locX;
        this.locY = locY;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
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

    public int getDimension() {
        return dimension;
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

    @Override
    public String toString() {
        return "EntrySymbol{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", locX=" + locX +
                ", locY=" + locY +
                ", dimension=" + dimension +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
