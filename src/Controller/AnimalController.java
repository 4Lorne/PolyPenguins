package Controller;

import Model.*;
import View.DataEntry;
import View.Reports;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalController {
    //Objects
    private final DataEntry dataEntry;
    private final Reports reports;
    private final ArrayList <Coordinates> coordinates = new ArrayList<>();
    private final ArrayList <Species> species = new ArrayList<>();

    //Used to get index of new coordinates, increments whenever a new object is made.
    private int count = 0;

    private final String coordinatesFilepath = "Output.txt";
    private final String coordinatesFilepathNew = "OutputWhitespaceRemoved.txt";

    public AnimalController(DataEntry dataEntry, Reports reports) {

        this.dataEntry = dataEntry;
        this.reports = reports;

        //Runs animalChosen on click which checks the name of the animal
        this.dataEntry.getSelectedAnimal(e -> {
            this.dataEntry.animalChosen();
            this.dataEntry.getName();
            this.dataEntry.getSex();
        });

        //Adds to the text area
        this.dataEntry.setBtnAddGPS(e -> {
            this.dataEntry.appendGPS();
        });

        //Prints the list of recent animals
        this.reports.setBtnShowNewEntries(e -> {
            this.reports.clearOutput();
            for (Species value : species) {
                this.reports.printAnimals(value.toString());
            }
            this.reports.titleChoice("Report: New Animal Entries");
        });

        //Prints coordinates to textarea
        //TODO: Remove blank lines between coordinates
        this.reports.setBtnShowGPSLogs(e -> {
            removeWhiteSpace(this.coordinatesFilepath);
            this.reports.clearOutput();
            this.reports.titleChoice("Report: All Logged GPS Positions To Date");
            try {
                this.reports.writeGPS(this.coordinatesFilepathNew);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //On button press
        this.dataEntry.setBtnAddEntry(e -> {
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
            String gender = dataEntry.getSex();
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


    //Credit: https://stackoverflow.com/questions/34999999/java-how-to-remove-blank-lines-from-a-text-file
    public void removeWhiteSpace(String filepath){
        File originalFile = new File(filepath);
        File newFile = new File("OutputWhitespaceRemoved.txt");
        Scanner file;
        PrintWriter writer;

        try {
            file = new Scanner(originalFile);
            writer = new PrintWriter(newFile);

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write("\n");
                }
            }
            file.close();
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
