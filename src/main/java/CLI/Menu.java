package CLI;

import Logic.PieceColor;
import Logic.Player;

import java.util.concurrent.atomic.AtomicBoolean;

public class Menu {

    private final String menuOptions;

    public Menu() {
        String newLine = System.getProperty("line.separator");
        menuOptions = "Insert:"
                + newLine + "'0' to play vs. another human;"
                + newLine + "'1' to play vs. AI;"
                + newLine + "'2' to quit.";
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public void Launch_menu(){
        Player player1, player2;
        AtomicBoolean exit = new AtomicBoolean(false);
        while (!exit.get()){
            Display.printMenu(this);
            int s = IO_Interface.getMenuChoice();
            switch(s) {
                case 0:
                    player1 = new Player(PieceColor.BLACK, IO_Interface.getName(PieceColor.BLACK));
                    System.out.println();
                    player2 = new Player(PieceColor.WHITE, IO_Interface.getName(PieceColor.WHITE));
                    System.out.println();
                    Game_cli gameHum = new Game_cli(player1,player2);
                    gameHum.playGame();
                    break;
                case 1:
                    player1 = new Player(PieceColor.BLACK);
                    System.out.println();
                    player2 = new Player(PieceColor.WHITE, IO_Interface.getName(PieceColor.WHITE));
                    System.out.println();
                    Game_cli gameAI = new Game_cli(player1,player2);
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


