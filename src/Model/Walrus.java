package Model;

import java.io.*;

public class Walrus extends Species implements ILoggable{
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
        return super.toString() + String.format("""
                Dental Health Status: %s
                GPS Positions:
                %s
                -------------------
                """,getDentalHealth(),super.getCoordinates());
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
