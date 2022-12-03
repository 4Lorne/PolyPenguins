package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reports extends JPanel {
    JLabel reportTitle = new JLabel("Reports");

    JButton btnShowNewEntries = new JButton("Show New Entries");
    JButton btnShowGPSLogs = new JButton("Show GPS Logs");
    JButton btnBack = new JButton("Back");

    JTextArea outputArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(outputArea);
    Border border = BorderFactory.createLineBorder(Color.BLACK);



    public Reports(){
        setLayout(null);
        //Title
        reportTitle.setBounds(10,20,400,15);
        add(reportTitle);
        //Text Area
        scrollPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollPane.setBounds(10,40,770,170);
        outputArea.setEditable(false);
        scrollPane.setAutoscrolls(false);
        add(scrollPane);
        //Button
        btnShowNewEntries.setBounds(100,220,175,25);
        add(btnShowNewEntries);
        //Button
        btnShowGPSLogs.setBounds(300,220,175,25);
        add(btnShowGPSLogs);
        //Button
        btnBack.setBounds(500,220,175,25);
        add(btnBack);
    }

    //Button listeners
    public void setBtnBack(ActionListener actionListener){
        btnBack.addActionListener(actionListener);
    }
    public void setBtnShowNewEntries(ActionListener actionListener){
        btnShowNewEntries.addActionListener(actionListener);
    }
    public void setBtnShowGPSLogs(ActionListener actionListener){
        btnShowGPSLogs.addActionListener(actionListener);
    }

    //Appends species array to the output area
    public void printAnimals(String input){
        outputArea.append(input);
    }

    //Changes the title based on the button pressed
    public void titleChoice(String input){
        reportTitle.setText(input);
    }

    //Need to create a new file reader object every time you use it
    public void writeGPS(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        outputArea.read(reader,"Output.txt");
        reader.close();
    }

    public void clearOutput(){
        outputArea.setText("");
    }
}
