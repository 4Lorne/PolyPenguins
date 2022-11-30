package Model;

import java.util.ArrayList;

public abstract class Species {
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

    public String getCoordinates() {
        return coordinates.toString();
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
