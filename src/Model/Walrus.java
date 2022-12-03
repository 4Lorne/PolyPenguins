package Model;

public class Walrus extends Species implements ILoggable{
    //Variables
    private final String dentalHealth;

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

}
