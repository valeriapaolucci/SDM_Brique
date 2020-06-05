package Logic;

import CLI.Display;
import CLI.Game_cli;
import CLI.IO_Interface;
import CLI.Menu;
import GUI.MainMenu;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Launch_Game {
    boolean play_with_gui;

    public Launch_Game(boolean gui) {
        this.play_with_gui = gui;
    }

    public void launch() {
        if (play_with_gui == true) {
            SwingUtilities.invokeLater(() -> {
                try {
                    new MainMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            Player player1, player2;
            Menu menu = new Menu();
            AtomicBoolean exit = new AtomicBoolean(false);
            while (!exit.get()) {
                Display.printMenu(menu);
                int s = IO_Interface.getMenuChoice();
                switch (s) {
                    case 0:
                        player1 = new Player(PieceColor.BLACK, IO_Interface.getName(PieceColor.BLACK));
                        System.out.println();
                        player2 = new Player(PieceColor.WHITE, IO_Interface.getName(PieceColor.WHITE));
                        System.out.println();
                        Game_cli gameHum = new Game_cli(player1, player2);
                        gameHum.playGame();
                        break;
                    case 1:
                        player1 = new Player(PieceColor.BLACK);
                        System.out.println();
                        player2 = new Player(PieceColor.WHITE, IO_Interface.getName(PieceColor.WHITE));
                        System.out.println();
                        Game_cli gameAI = new Game_cli(player1, player2);
                        gameAI.playGame();
                        break;
                    case 2:
                        exit.set(true);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
            }
            System.out.println("Bye!");
        }
    }
}
