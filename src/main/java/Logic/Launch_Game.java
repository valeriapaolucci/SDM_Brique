package Logic;

import GUI.MainMenu;

import javax.swing.*;
import java.io.IOException;

public class Launch_Game {

    public Launch_Game() {}

    public void launch() {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}