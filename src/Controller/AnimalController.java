package Controller;

import View.DataEntry;
import View.Reports;

public class AnimalController {
    //Objects
    private DataEntry dataEntry;
    private Reports reports;

    public AnimalController(DataEntry dataEntry, Reports reports){
        this.dataEntry = dataEntry;
        this.reports = reports;
    }
}
