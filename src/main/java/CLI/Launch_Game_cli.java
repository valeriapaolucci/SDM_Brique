package CLI;

import Logic.PieceColor;
import Logic.Player;

import java.util.concurrent.atomic.AtomicBoolean;

public class Launch_Game_cli {

    public Launch_Game_cli(){}

    public void launch(){
        Player player1, player2;
        Menu menu = new Menu();
        AtomicBoolean exit = new AtomicBoolean(false);
        while (!exit.get()){
            Display.printMenu(menu);
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

