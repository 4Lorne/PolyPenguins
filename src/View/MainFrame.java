package View;

import Controller.AnimalController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private CardLayout cardLayout;

    public MainFrame(){
        init();
    }

    public void init(){
        setTitle("Antarctic Animal Tracking");
        cardLayout = new CardLayout();
        //Views
        DataEntry dataEntry = new DataEntry();
        Reports reports = new Reports();

        //Objects


        //Setting layout
        setLayout(cardLayout);


        //Controller
        new AnimalController(dataEntry,reports);

        //Adding views to the frame
        add(reports,"Reports");
        add(dataEntry,"Data Entry");

        setSize(800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
