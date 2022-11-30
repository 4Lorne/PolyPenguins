package Controller;

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
    private ArrayList <String> coordinates = new ArrayList<String>();
    private ArrayList <Species> species = new ArrayList<Species>();

    public AnimalController(DataEntry dataEntry, Reports reports){
        this.dataEntry = dataEntry;
        this.reports = reports;

        //Runs animalChosen on click which checks the name of the animal
        this.dataEntry.getSelectedAnimal(e -> {
            this.dataEntry.animalChosen();
            this.dataEntry.getName();
            this.dataEntry.getGender();
        });

        this.dataEntry.setAddGPS(e -> {
            this.coordinates.add(dataEntry.getCoords());
            this.dataEntry.appendGPS();
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
            //TODO: Check for at least one GPS location
            //Gathering values to create a species object
            String name = dataEntry.addAnimal();
            String gender = dataEntry.getGender();
            int weight = dataEntry.getWeight();
            if (this.dataEntry.animalChosen().matches("Penguin")){
                int bloodPressure = dataEntry.getBP();
                Penguin penguin = new Penguin(name,gender,weight,coordinates,bloodPressure);
                species.add(penguin);
                System.out.println(species);
            }
        });


    }
}
