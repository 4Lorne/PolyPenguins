package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DataEntry extends JPanel {
    JLabel animalObserved = new JLabel("Animal Observed:");
    JLabel animal = new JLabel("Animal");
    JLabel gender = new JLabel("Gender");
    JLabel weight = new JLabel("Weight in Kg");
    JLabel dental = new JLabel("Dental Health");
    JLabel spots = new JLabel("Spots");
    JLabel bloodPressure = new JLabel("Blood Pressure");
    JLabel coordinates = new JLabel("GPS Coordinates: (-)##.####### (-)(## or ###).#######");

    JButton btnAddEntry = new JButton("Add Entry");
    JButton btnAddGPS = new JButton("Add GPS");
    JButton btnViewReports = new JButton("View Reports");

    String[] animalNameArray = {"Penguin", "Sea Lion", "Walrus"};
    String[] animalSexArray = {"Male", "Female"};
    String[] dentalHealthArray = {"Good","Average","Poor"};
    JComboBox<String> animalCSpecies = new JComboBox<>(animalNameArray);
    JComboBox<String> animalCSex = new JComboBox<>(animalSexArray);
    JComboBox<String> dentalCCombo = new JComboBox<>(dentalHealthArray);

    JTextField addCoords = new JTextField(20);
    JTextField weightEntry = new JTextField(6);
    JTextField bloodPressureEntry = new JTextField(6);
    JTextField spotsEntry = new JTextField(6);

    JTextArea coordList = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(coordList);

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
        animalCSpecies.setBounds(120,45,100,25);
        add(animalCSpecies);
        //Label
        gender.setBounds(10,80,100,10);
        add(gender);
        //Combo Box
        animalCSex.setBounds(120,75,100,25);
        add(animalCSex);

        //Label
        weight.setBounds(10,110,100,15);
        add(weight);

        //Text Field
        weightEntry.setBounds(120,105,100,25);
        add(weightEntry);

        //Label for the three options
        bloodPressure.setBounds(10,145,100,15);
        add(bloodPressure);

        spots.setBounds(10,145,100,15);
        spots.setVisible(false);
        add(spots);

        dental.setBounds(10,145,100,15);
        dental.setVisible(false);
        add(dental);

        //Text Field
        bloodPressureEntry.setBounds(120,135,100,25);
        add(bloodPressureEntry);

        spotsEntry.setBounds(120,135,100,25);
        add(spotsEntry);

        dentalCCombo.setBounds(120,135,100,25);
        add(dentalCCombo);

        //Button
        btnAddEntry.setBounds(60,170,100,25);
        add(btnAddEntry);


        //Text field
        addCoords.setBounds(350,40,300,25);
        add(addCoords);

        //Button
        btnAddGPS.setBounds(660,40,100,25);
        add(btnAddGPS);

        //Text Area
        scrollPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollPane.setBounds(350,70,410,125);
        coordList.setEditable(false);
        scrollPane.setAutoscrolls(true);
        add(scrollPane);

        //Button
        btnViewReports.setBounds(610,215,150,25);
        add(btnViewReports);
    }
    //Listener for buttons
    public void setBtnAddEntry(ActionListener actionListener){
        btnAddEntry.addActionListener(actionListener);
    }
    public void setBtnAddGPS(ActionListener actionListener){
        btnAddGPS.addActionListener(actionListener);
    }
    public void setBtnViewReports(ActionListener actionListener){
        btnViewReports.addActionListener(actionListener);
    }

    //Checks for the animal and shows relevant choices depending on what is chosen.
    public void getSelectedAnimal(ActionListener actionListener){
        animalCSpecies.addActionListener(actionListener);
    }

    //Sets visibility based on choice
    public String animalChosen(){
        if (Objects.requireNonNull(animalCSpecies.getSelectedItem()).toString().contains("Penguin")){
                bloodPressure.setVisible(true);
                spots.setVisible(false);
                dental.setVisible(false);

                bloodPressureEntry.setVisible(true);
                spotsEntry.setVisible(false);
                dentalCCombo.setVisible(false);

        } else if (Objects.requireNonNull(animalCSpecies.getSelectedItem()).toString().contains("Sea Lion")){
                spots.setVisible(true);
                bloodPressure.setVisible(false);
                dental.setVisible(false);

                spotsEntry.setVisible(true);
                bloodPressureEntry.setVisible(false);
                dentalCCombo.setVisible(false);

        } else if (Objects.requireNonNull(animalCSpecies.getSelectedItem()).toString().contains("Walrus")){
                dental.setVisible(true);
                bloodPressure.setVisible(false);
                spots.setVisible(false);

                dentalCCombo.setVisible(true);
                bloodPressureEntry.setVisible(false);
                spotsEntry.setVisible(false);
        }
        return animalCSpecies.getSelectedItem().toString();
    }

    //Notifies of successful addition, returns selected animal
    public String addAnimal(){
        JOptionPane.showMessageDialog(null,animalChosen()+" saved as a new entry.");
        return Objects.requireNonNull(animalCSpecies.getSelectedItem()).toString();
    }

    //Regex for validation of animal chosen
    public boolean checkInputAnimal(JTextField input){
        if (input.getText().matches("\\D+")){ //Anything besides digits
            return true;
        } else if (input.getText().matches("^$")){ //Empty string
            return true;
        } else if (Integer.parseInt(input.getText()) <= 0 ){
            return true;
        } else{
            return false;
        }
    }

    //Adds coordinates to the coordList
    public void appendGPS(){
        if (this.checkInputGPS()) {
            coordList.append(addCoords.getText()+"\n");
            addCoords.setText("");
        }
    }

    //Regex checks for valid input
    public boolean checkInputGPS(){
        if (!addCoords.getText().matches("^(-?\\d{2}([.]\\d{7})?) \\s*(-?\\d{2,3}([.]\\d{7})?)$")){
            gpsError();
            return false;
        }else if (addCoords.getText().length() < 18){
            gpsError();
            return false;
        }else {
            return true;
        }
    }

    //Pops up if there is an error with the GPS coordinates
    public void gpsError(){
        JOptionPane.showMessageDialog(null,
                """
                        Invalid GPS format
                        Latitude values range from -90 to 90.
                        Longitudes values range from -180 to 180.
                        Both values must have 7 digits after the decimal.
                        Separate latitude and longitude values with a space.
                        (-)##.####### (-)(## or ###).#######
                        """);
    }

    //Getters
    public String getSex(){
        return Objects.requireNonNull(animalCSex.getSelectedItem()).toString();
    }

    //Clears the data so new animal can be added.
    public void clearData(){
        animalCSpecies.setSelectedIndex(0);
        animalCSex.setSelectedIndex(0);
        dentalCCombo.setSelectedIndex(0);
        spotsEntry.setText("");
        weightEntry.setText("");
        spotsEntry.setText("");
        bloodPressureEntry.setText("");
        coordList.setText("");
    }

    public JTextField getWeightEntry() {
        return weightEntry;
    }

    public JTextField getBloodPressureEntry() {
        return bloodPressureEntry;
    }

    public JTextField getSpotsEntry() {
        return spotsEntry;
    }

    public JLabel getBloodPressure() {
        return bloodPressure;
    }

    public JLabel getSpots() {
        return spots;
    }

    public int getWeight() {
        return Integer.parseInt(weightEntry.getText());
    }

    public int getBP(){
        return Integer.parseInt(bloodPressureEntry.getText());
    }

    public String getCoords(){
        return coordList.getText();
    }

    public String getDental(){
        return Objects.requireNonNull(dentalCCombo.getSelectedItem()).toString();
    }

    public int getNumSpots(){
        return Integer.parseInt(spotsEntry.getText());
    }
}
