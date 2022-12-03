package Model;

public class Coordinates extends Species implements ILoggable {
    //Variables
    private final String coordinates;

    //Constructor
    public Coordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    //toString method
    @Override
    public String toString() {
        return getCoordinates();
    }
}
