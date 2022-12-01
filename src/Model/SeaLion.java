package Model;

import java.io.*;

public class SeaLion extends Species implements ILoggable{
    //Variables
    private int numSpots;

    //Constructor
    public SeaLion(String name, String gender, Coordinates coordinates, int weight, int numSpots){
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
        return super.toString() + String.format("""
                Number of Spots: %d
                GPS Positions:
                %s
                -------------------
                """,getNumSpots(),super.getCoordinates());
    }
}
