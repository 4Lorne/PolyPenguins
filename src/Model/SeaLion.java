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

    @Override
    public void createFile() {
        try {
            FileWriter writer = new FileWriter("Output.txt",true);
            writer.append(getCoordinates()).append("\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String outputFile() {
        try {
            FileReader output = new FileReader("Output.txt");
            int content;
            while ((content = output.read()) != -1){
                System.out.print((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
