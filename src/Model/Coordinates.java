package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Coordinates implements ILoggable {
    private String coordinates;

    public Coordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    @Override
    public void createFile() {
        try {
            PrintWriter writer = new PrintWriter("Output.txt");
            writer.println(getCoordinates());
            writer.close();
        } catch (FileNotFoundException e) {
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

    @Override
    public String toString() {
        return getCoordinates();
    }
}
