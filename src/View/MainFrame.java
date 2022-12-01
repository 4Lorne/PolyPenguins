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

        dataEntry.setViewReports(e -> {
            cardLayout.show(MainFrame.this.getContentPane(),"Reports");
        });

        reports.setBack(e -> {
            cardLayout.show(MainFrame.this.getContentPane(),"Data Entry");
        });
        setSize(800,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Creates file on startup
    public void createFile() {
        try {
            FileWriter writer = new FileWriter("Output.txt",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
