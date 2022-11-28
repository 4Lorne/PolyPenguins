package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DataEntry extends JPanel {
    JLabel animalObserved = new JLabel("Animal Observed:", JLabel.LEFT);
    JLabel animal = new JLabel("Animal", JLabel.LEFT);
    JLabel gender = new JLabel("Gender", JLabel.LEFT);
    JLabel weight = new JLabel("Weight in Kg", JLabel.LEFT);
    JLabel bloodPressure = new JLabel("Blood Pressure", JLabel.LEFT);
    JLabel coordinates = new JLabel("GPS Coordinates: (-)##.####### (-)(## or ###).#######");

    JButton addEntry = new JButton("Add Entry");
    JButton addGPS = new JButton("Add GPS");
    JButton viewReports = new JButton("View Reports");

    String[] animalArray = {"Penguin", "Sea Lion", "Walrus"};
    String[] animalGender = {"Male", "Female"};
    JComboBox<String> animalBox = new JComboBox<String>(animalArray);
    JComboBox<String> animalGBox = new JComboBox<String>(animalGender);

    JTextField addCoords = new JTextField(20);
    JTextField weightEntry = new JTextField(6);
    JTextField bloodPressureEntry = new JTextField(6);
    JTextArea coordList = new JTextArea();

    Border border = BorderFactory.createLineBorder(Color.BLACK);

    public DataEntry() {
        setLayout(null);
        //Label
        animalObserved.setBounds(10,20,100,10);
        add(animalObserved);
        //Label
        coordinates.setBounds(350,20,350,10);
        add(coordinates);
        //Label
        animal.setBounds(10,50,100,10);
        add(animal);
        //Combo Box
        animalBox.setBounds(120,45,100,25);
        add(animalBox);
        //Label
        gender.setBounds(10,80,100,10);
        add(gender);
        //Combo Box
        animalGBox.setBounds(120,75,100,25);
        add(animalGBox);

        //Label
        weight.setBounds(10,110,100,15);
        add(weight);

        //Text Field
        weightEntry.setBounds(120,105,100,25);
        add(weightEntry);

        //Label
        bloodPressure.setBounds(10,145,100,10);
        add(bloodPressure);

        //Text Field
        bloodPressureEntry.setBounds(120,135,100,25);
        add(bloodPressureEntry);

        //Button
        addEntry.setBounds(60,170,100,25);
        add(addEntry);


        //Text field
        addCoords.setBounds(350,40,300,25);
        add(addCoords);

        //Button
        addGPS.setBounds(660,40,100,25);
        add(addGPS);

        //Text Area
        coordList.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        coordList.setBounds(350,70,410,125);
        add(coordList);

        //Button
        viewReports.setBounds(610,215,150,25);
        add(viewReports);
    }
}
