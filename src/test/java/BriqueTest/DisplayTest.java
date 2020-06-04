package BriqueTest;

import Logic.*;
import static CLI.Display.printBoard;
import org.junit.Test;
import org.junit.Assert;


public class DisplayTest {

    @Test
    public void testDisplay() {
        Board board = new Board();
        board.getCell(new Coordinates(0,0)).setState(State.B_PIECE);
        board.getCell(new Coordinates(0,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(10,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(14,14)).setState(State.B_PIECE);

        printBoard(board);
    }

}



