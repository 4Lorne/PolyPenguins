package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Species {
    //Variables
    private String name;
    private String gender;
    private ArrayList<String> coordinates;
    private int weight;


    //Constructor
    public Species(){

    }

    public Species(String name, String gender, ArrayList<String> coordinates, int weight){
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
        return "Species{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", coordinates=" + coordinates +
                ", weight=" + weight +
                '}';
    }
}
