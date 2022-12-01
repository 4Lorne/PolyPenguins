import View.MainFrame;

import javax.swing.*;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainFrame();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
