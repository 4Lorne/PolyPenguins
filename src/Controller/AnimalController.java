package Controller;

import Model.Species;
import View.DataEntry;
import View.Reports;

import javax.swing.*;

public class AnimalController {
    //Objects
    private DataEntry dataEntry;
    private Reports reports;
    private Species species;

    public AnimalController(DataEntry dataEntry, Reports reports){
        this.dataEntry = dataEntry;
        this.reports = reports;

        //Runs animalChosen on click which checks the name of the animal
        this.dataEntry.getSelectedAnimal(e -> {
            this.dataEntry.animalChosen();
        });

        this.dataEntry.setAddGPS(e -> {
            this.dataEntry.appendGPS();
        });

        //Input validation when you press add entry
        this.dataEntry.setAddEntry(e -> {
            //JOptionPane.showMessageDialog(null,this.dataEntry.animalChosen()+" saved as a new entry.");
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
            this.dataEntry.addAnimal();
        });


    }
}
