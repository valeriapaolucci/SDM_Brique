package BriqueTest;


import Data.PieceColor;
import Data.Player;
import Logic.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {





    @Test
    public void Hum_vs_AI() {
        Player player_1 = new Player(PieceColor.BLACK, "Human");
        Player player_2 = new Player(PieceColor.WHITE);

        check_cell_init(player_1, player_2);
    }


    private void check_cell_init(Player player_1, Player player_2) {
        Game game = new Game(player_1,player_2);
        assertTrue(game.getPlayer_1().isHuman());
        assertFalse(game.getPlayer_2().isHuman());
        assertEquals(PieceColor.WHITE,game.getPlayer_2().getControl());
        assertEquals("Human",game.getPlayer_1().getName());
        assertEquals("AI",game.getPlayer_2().getName());

    }
}
