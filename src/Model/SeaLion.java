package Model;

import java.util.ArrayList;

public class SeaLion extends Species{
    //Variables
    private int numSpots;

    //Constructor
    public SeaLion(String name, String gender, ArrayList<String> coordinates, int weight, int numSpots){
        super(name,gender,coordinates,weight);
        this.numSpots = numSpots;
    }

    //Getters
    public int getNumSpots() {
        return numSpots;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + numSpots;
    }
}
