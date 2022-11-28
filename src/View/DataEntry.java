package View;

import javax.swing.*;
import java.awt.*;

public class DataEntry extends JPanel {
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private GridBagConstraints gc = new GridBagConstraints();

    JLabel animalObserved = new JLabel("Animal Observed:");
    JLabel animal = new JLabel("Animal");
    JLabel gender = new JLabel("Gender");
    JLabel weight = new JLabel("Weight in Kg");
    JLabel bloodPressure = new JLabel("Blood Pressure");
    JLabel coordinates = new JLabel("GPS Coordinates: (-)##.####### (-)(## or ###).#######");

    JButton addEntry = new JButton("Add Entry");
    JButton addGPS = new JButton("Add GPS");
    JButton viewReports = new JButton("View Reports");

    String[] animalArray = {"Penguin", "Sea Lion", "Walrus"};
    String[] animalGender = {"Male", "Female"};
    JComboBox<String> animalBox = new JComboBox<String>(animalArray);
    JComboBox<String> animalGBox = new JComboBox<String>(animalGender);

    JTextField addCoords = new JTextField(20);
    JTextArea coordList = new JTextArea();


    public DataEntry() {
        setLayout(gridBagLayout);
        gc.insets = new Insets(5, 5, 5, 5);
        gc.gridwidth = 10;

        gc.gridx = 0;
        gc.gridy = 0;
        add(animalObserved, gc);

        gc.gridy = 3;
        add(animal, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(animalBox, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(gender, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(animalGBox, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        add(weight, gc);

        gc.gridy = 6;
        add(bloodPressure, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        add(coordinates);

        gc.gridy = 7;
        add(addEntry, gc);
        add(addGPS);
        add(viewReports);
        add(addCoords, gc);
    }
}
