package View;

import Controller.AnimalController;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame{
    private CardLayout cardLayout;

    public MainFrame() throws FileNotFoundException {
        createFile();
        init();
    }

    //Initializer
    public void init() throws FileNotFoundException {
        setTitle("Antarctic Animal Tracking");
        cardLayout = new CardLayout();
        //Views
        DataEntry dataEntry = new DataEntry();
        Reports reports = new Reports();

        //Setting layout
        setLayout(cardLayout);

        //Controller
        new AnimalController(dataEntry,reports);

        //Adding views to the frame
        add(dataEntry,"Data Entry");
        add(reports,"Reports");

        dataEntry.setBtnViewReports(e -> {
            cardLayout.show(MainFrame.this.getContentPane(),"Reports");
        });

        reports.setBtnBack(e -> {
            cardLayout.show(MainFrame.this.getContentPane(),"Data Entry");
        });
        setSize(800,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Creates file on startup if one does not already exist
    public void createFile() {
        try {
            FileWriter writer = new FileWriter("Output.txt",true);
            FileWriter writer2 = new FileWriter("OutputWhitespaceRemoved.txt",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
