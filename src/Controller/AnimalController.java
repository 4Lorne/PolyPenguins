package Controller;

import View.DataEntry;
import View.Reports;

import javax.swing.*;

public class AnimalController {
    //Objects
    private DataEntry dataEntry;
    private Reports reports;

    public AnimalController(DataEntry dataEntry, Reports reports){
        this.dataEntry = dataEntry;
        this.reports = reports;

        this.dataEntry.getSelectedAnimal(e -> {
            this.dataEntry.animalChosen();
        });

        this.dataEntry.setAddEntry(e -> {
            JOptionPane.showMessageDialog(null,this.dataEntry.animalChosen()+" saved as a new entry.");
            if (this.dataEntry.checkWeight()){
                JOptionPane.showMessageDialog(null,"[Weight]: Invalid input: \nEnter a whole number greater than 0.");
            }
        });
    }
}
