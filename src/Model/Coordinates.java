package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Coordinates extends Species implements ILoggable {
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
