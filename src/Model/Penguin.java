package Model;

import java.io.*;

public class Penguin extends Species implements ILoggable{
    //Variables
    private double bloodPressure;

    //Constructor
    public Penguin(){

    }
    public Penguin(String name, String gender, int weight, Coordinates coordinates, double bloodPressure){
        super(name,gender,coordinates,weight);
        this.bloodPressure = bloodPressure;
    }

    //Getter
    public double getBloodPressure() {
        return bloodPressure;
    }

    //Setter
    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
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

    //toString
    @Override
    public String toString() {
        return super.toString() + String.format("""
                Blood Pressure: %.1f
                GPS Positions:
                %s
                -------------------
                """,getBloodPressure(),super.getCoordinates());
    }
}
