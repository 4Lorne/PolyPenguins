package Model;

public class Penguin extends Species implements ILoggable{
    //Variables
    private final double bloodPressure;

    public Penguin(String name, String gender, int weight, Coordinates coordinates, double bloodPressure){
        super(name,gender,coordinates,weight);
        this.bloodPressure = bloodPressure;
    }

    //Getter
    public double getBloodPressure() {
        return bloodPressure;
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
