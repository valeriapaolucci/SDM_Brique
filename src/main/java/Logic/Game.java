package Logic;

public class Game {

    public boolean pieRule = false;
    public Player player_1, player_2;
    boolean isMultiplayer;
    public Board board;
    int move_counter = 0;

    public Game(Player player_1, Player player_2, boolean isMultiplayer){
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.isMultiplayer = isMultiplayer;
        board = new Board();
    }


    public Player getPlayer_1() {
        return player_1;
    }

    public Player getPlayer_2() {
        return player_2;
    }

    public Player getCurrent_player(){
        if (player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Player getOther_player(){
        if (!player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getMove_counter() { return move_counter; }

    public void increaseMoveCounter(){
        this.move_counter++;
    }

}




