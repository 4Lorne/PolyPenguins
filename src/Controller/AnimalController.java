package Controller;

import Model.*;
import View.DataEntry;
import View.Reports;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class AnimalController {
    //Objects
    private DataEntry dataEntry;
    private Reports reports;
    private ArrayList <Coordinates> coordinates = new ArrayList<>();
    private ArrayList <Species> species = new ArrayList<Species>();

    //Used to get index of new coordinates, increments whenever a new object is made.
    private int count = 0;

    //TODO: Fix FILE IO
    BufferedReader reader;
    {
        try {
            FileReader file = new FileReader("Output.txt");
            reader = new BufferedReader(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
            for (int i = 0; i < species.size();i++){
                this.reports.printAnimals(species.get(i).toString());
            }
            this.reports.titleChoice();
        });

        this.reports.setShowGPSLogs(e -> {
            for (int i = 0; i < species.size();i++){
                this.reports.writeGPS(reader);
            }
        });

        //On button press
        this.dataEntry.setAddEntry(e -> {
            //Input validation when you press add entry
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

            //Gathering values to create a species object
            String name = dataEntry.addAnimal();
            String gender = dataEntry.getGender();
            int weight = dataEntry.getWeight();
            this.coordinates.add(new Coordinates(dataEntry.getCoords()));

            //Checks for the animal, uses specific getters based on choice.
            if (this.dataEntry.animalChosen().matches("Penguin")){
                int bloodPressure = dataEntry.getBP();
                Penguin penguin = new Penguin(name,gender,weight,coordinates.get(count),bloodPressure);
                penguin.createFile();
                this.species.add(penguin);
                System.out.println(species);
            } else if (this.dataEntry.animalChosen().matches("Walrus")){
                String dentalHealth = this.dataEntry.getDental();
                Walrus walrus = new Walrus(name,gender, coordinates.get(count), weight,dentalHealth);
                walrus.createFile();
                this.species.add(walrus);
            } else if (this.dataEntry.animalChosen().matches("Sea Lion")){
                int numSpots = this.dataEntry.getNumSpots();
                SeaLion seaLion = new SeaLion(name,gender,coordinates.get(count),weight,numSpots);
                seaLion.createFile();
                this.species.add(seaLion);
            }

            //Resets all fields after each object is created
            this.dataEntry.clearData();
            //Increments
            this.count++;
        });


    }
}
