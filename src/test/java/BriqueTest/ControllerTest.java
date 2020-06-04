package BriqueTest;

import Logic.*;
import org.junit.Test;
import org.junit.Assert;

public class ControllerTest {
    @Test
    public void Check_check_victory() {
        Graph white_graph = new Graph(PieceColor.WHITE);
        Graph black_graph = new Graph(PieceColor.BLACK);
        Board white_board = new Board();
        Board black_board = new Board();
        for (int i = 0; i < 15; i = i + 1) {
            Coordinates horizontal_coordinates = new Coordinates(1, i);
            Coordinates vertical_coordinates = new Coordinates(i, 1);
            white_board.getCell(horizontal_coordinates).setState(State.W_PIECE);
            white_graph.update_graph(horizontal_coordinates, white_board);
            black_board.getCell(vertical_coordinates).setState(State.B_PIECE);
            black_graph.update_graph(vertical_coordinates, black_board);


        }
        Assert.assertTrue(Controller.check_victory(white_graph));
        Assert.assertTrue(Controller.check_victory(black_graph));
    }

    @Test
    public void check_switchPlayer(){
        Game game = set_initial_game();
        Controller.switchPlayer(game);
        Assert.assertEquals(game.getCurrent_player(),game.getPlayer_2());
    }

    @Test
    public void check_areEmpty(){
        Board board = new Board();
        Coordinates coordinates = new Coordinates(1, 2);
        Assert.assertTrue(Controller.areEmpty(board,coordinates));
    }

    @Test
    public void check_swapGraphs(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");
        Graph player1_graph = player1.getGraph();
        Controller.swapGraphs(player1,player2);
        Assert.assertEquals(player1_graph,player2.getGraph());
    }



    public Game set_initial_game(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");
        return new Game(player1,player2, true);

    }

}
