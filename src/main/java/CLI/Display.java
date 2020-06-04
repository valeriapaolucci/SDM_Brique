package CLI;

import Logic.*;

public class Display {

    static void printMove(Game_cli game){
        System.out.print("Move #" + game.getMove_counter() + " (" + game.getCurrent_player().getName() + "-" + game.getCurrent_player().getControl() + ")");
        System.out.println();
    }

    public static void printBoard(Board board) {
        System.out.print("   ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            System.out.print(" " + (char) (i + 'a'));
        }
        System.out.println(" ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            if (i > 5) System.out.print(" ");
            System.out.print(15 - i + " ");
            for (int j = 0; j < Board.dim; j = j + 1) {
                Coordinates temp = new Coordinates(i, j);
                if (board.getCell(temp).getState() == State.B_PIECE) {
                    System.out.print("|" + "B");
                } else if (board.getCell(temp).getState() == State.W_PIECE) {
                    System.out.print("|" + "W");
                } else if ((i * 15 + j) % 2 == 0) {
                    System.out.print("|#");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("| ");
            System.out.println(15 - i);
        }
        System.out.print("   ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            System.out.print(" " + (char) (i + 'a'));
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");
    }

    static void printMenu(Menu menu) {
        System.out.println(menu.getMenuOptions());
    }

    static void printResignedMessage(Game_cli game){
        System.out.println(game.getCurrent_player().getName() + " resigned!");
    }

    static void printVictoryMessage(Game_cli game){
        System.out.println(game.getCurrent_player().getName() + " WINS!");
    }

}

