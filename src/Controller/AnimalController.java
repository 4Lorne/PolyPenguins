package Controller;

import Model.Coordinates;
import Model.Penguin;
import Model.Species;
import View.DataEntry;
import View.Reports;

import javax.swing.*;
import java.util.ArrayList;

public class AnimalController {
    //Objects
    private DataEntry dataEntry;
    private Reports reports;
    private ArrayList <Coordinates> coordinates = new ArrayList<>();
    private ArrayList <Species> species = new ArrayList<Species>();

    //Used to get index of new coordinates, increments whenever a new object is made.
    private int count = 0;

    public AnimalController(DataEntry dataEntry, Reports reports){
        this.dataEntry = dataEntry;
        this.reports = reports;

        //Runs animalChosen on click which checks the name of the animal
        this.dataEntry.getSelectedAnimal(e -> {
            this.dataEntry.animalChosen();
            this.dataEntry.getName();
            this.dataEntry.getGender();
        });

        //Adds to the text area
        this.dataEntry.setAddGPS(e -> {
            this.dataEntry.appendGPS();
        });

        //Prints the list of recent animals
        this.reports.setShowNewEntries(e -> {
            //TODO: Make coordinates stop printing all the coordinates
            for (int i = 0; i < species.size();i++){
                reports.printAnimals(species.get(i).toString());
            }

        });

        //Input validation when you press add entry
        this.dataEntry.setAddEntry(e -> {
            //Validation
            if (this.dataEntry.checkInputAnimal(this.dataEntry.getWeightEntry())){
                JOptionPane.showMessageDialog(null,"[Weight]: Invalid input: \nEnter a whole number greater than 0.");
                return;
            }

            if (this.dataEntry.getSpots().isVisible()){
                if (this.dataEntry.checkInputAnimal((this.dataEntry.getSpotsEntry()))){
                    JOptionPane.showMessageDialog(null,"[Spots]: Invalid input: \nEnter a whole number greater than 0.");
                    return;
                }
            }

            if(this.dataEntry.getBloodPressure().isVisible()){
                if (this.dataEntry.checkInputAnimal(this.dataEntry.getBloodPressureEntry())){
                    JOptionPane.showMessageDialog(null,"[Blood Pressure]: Invalid input: \nEnter a whole number greater than 0.");
                    return;
                }
            }

            if (dataEntry.getCoords().isEmpty()){
                JOptionPane.showMessageDialog(null,"At least one GPS location must be entered");
                return;
            }
            //TODO: Check for at least one GPS location
            //Gathering values to create a species object
            String name = dataEntry.addAnimal();
            String gender = dataEntry.getGender();
            int weight = dataEntry.getWeight();

            this.coordinates.add(new Coordinates(dataEntry.getCoords()));

            if (this.dataEntry.animalChosen().matches("Penguin")){
                int bloodPressure = dataEntry.getBP();
                Penguin penguin = new Penguin(name,gender,weight,coordinates.get(count),bloodPressure);
                species.add(penguin);
                System.out.println(species);
            }

            //Resets all fields after each object is created
            this.dataEntry.clearData();
            //Increments
            this.count++;
        });


    }
}
