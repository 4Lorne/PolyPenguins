package Model;

import java.util.ArrayList;

public class Walrus extends Species{
    //Variables
    private String dentalHealth;

    //Constructor
    public Walrus(String name, String gender, Coordinates coordinates, int weight, String dentalHealth){
        super(name,gender,coordinates,weight);
        this.dentalHealth = dentalHealth;
    }

    //Getters
    public String getDentalHealth() {
        return dentalHealth;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + dentalHealth;
    }
}
