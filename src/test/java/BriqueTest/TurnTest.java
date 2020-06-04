package BriqueTest;

import Logic.*;
import org.junit.Test;
import org.junit.Assert;

public class TurnTest {


    @Test
    public void check_playTurn(){
        Game game =  set_initial_game();
        Coordinates coordinates = new Coordinates(1, 2);
        Turn turn = new Turn(game, coordinates);
        turn.playTurn();
        Assert.assertEquals(game.getBoard().getCell(coordinates).getState(), State.B_PIECE);

    }




    public Game set_initial_game(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");

        return new Game(player1,player2, true);

    }
}
