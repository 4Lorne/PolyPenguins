package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reports extends JPanel {
    JLabel reportTitle = new JLabel("Reports");

    JButton showNewEntries = new JButton("Show New Entries");
    JButton showGPSLogs = new JButton("Show GPS Logs");
    JButton back = new JButton("Back");

    JTextArea coordList = new JTextArea();

    Border border = BorderFactory.createLineBorder(Color.BLACK);

    public Reports(){
        setLayout(null);
        //Title
        reportTitle.setBounds(10,20,100,15);
        add(reportTitle);
        //Text Area
        coordList.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        coordList.setBounds(10,40,770,170);
        add(coordList);
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
}
