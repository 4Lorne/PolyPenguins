package Model;

public class Coordinates {
    private String coordinates;

    public Coordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return getCoordinates();
    }
}
