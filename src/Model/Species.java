package Model;

import java.io.*;

public abstract class Species implements ILoggable{
    //Variables
    private String name;
    private String gender;
    private Coordinates coordinates;
    private int weight;


    //Constructor
    public Species(){

    }

    public Species(String name, String gender, Coordinates coordinates, int weight){
        this.name = name;
        this.gender = gender;
        this.coordinates = coordinates;
        this.weight = weight;
    }

    public void createFile() {
        try {
            FileWriter writer = new FileWriter("Output.txt",true);
            writer.append(getCoordinates()).append("\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getWeight() {
        return weight;
    }

    //Returns the coordinate string
    public String getCoordinates() {
        return coordinates.getCoordinates();
    }

    @Override
    public String toString() {
        return String.format("""
                Species: %s
                Gender: %s
                Weight: %d
                """,getName(),getGender(),getWeight());
    }
}
