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
    JLabel reportGPSLogs = new JLabel("Report: All Logged GPS Positions To Date");

    JButton showNewEntries = new JButton("Show New Entries");
    JButton showGPSLogs = new JButton("Show GPS Logs");
    JButton back = new JButton("Back");

    JTextArea coordList = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(coordList);
    Border border = BorderFactory.createLineBorder(Color.BLACK);



    public Reports(){
        setLayout(null);
        //Title
        reportTitle.setBounds(10,20,400,15);
        add(reportTitle);
        //Text Area
        scrollPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollPane.setBounds(10,40,770,170);
        coordList.setEditable(false);
        scrollPane.setAutoscrolls(false);
        add(scrollPane);
        //Button
        showNewEntries.setBounds(100,220,175,25);
        add(showNewEntries);
        //Button
        showGPSLogs.setBounds(300,220,175,25);
        add(showGPSLogs);
        //Button
        back.setBounds(500,220,175,25);
        add(back);
    }

    public void setBack(ActionListener actionListener){
        back.addActionListener(actionListener);
    }
    public void setShowNewEntries(ActionListener actionListener){
        showNewEntries.addActionListener(actionListener);
    }

    public void setShowGPSLogs(ActionListener actionListener){
        showGPSLogs.addActionListener(actionListener);
    }

    public void printAnimals(String input){
        cleanOutput();
        coordList.append(input);
    }

    public void titleChoice(String input){
        reportTitle.setText(input);
    }

    public void writeGPS(BufferedReader reader) throws IOException {
        cleanOutput();
        coordList.read(reader,"Output.txt");
    }

    public void cleanOutput(){
        coordList.setText("");
    }
}
