package CLI;

import Logic.*;

import java.util.concurrent.atomic.AtomicBoolean;


public class Game_cli {
    private final Player player_1;
    private final Player player_2;
    private final Board board;
    private int move_counter = 0;


    public Game_cli(Player player_1, Player player_2) {
        this.player_1 = player_1;
        this.player_2 = player_2;
        board = new Board();
        player_1.setCurrent(true);
    }


    public void playGame(){
        if(player_1.isHuman()) Display.printBoard(board);
        AtomicBoolean victory = new AtomicBoolean(false);
        while (!victory.get()){
            move_counter++;
            Turn_cli turn = new Turn_cli(this);
            turn.playTurn();
            if(getCurrent_player().isResigned()){
                Display.printResignedMessage(this);
                break;
            }
            Display.printMove(this);
            Display.printBoard(board);
            if(move_counter==1){
                Controller.switchPlayer(this);
                boolean pie_bool = IO_Interface.getPieRule(getCurrent_player());
                Controller.apply_pie_rule(this, pie_bool);
            }
            if(move_counter >= 28){
                victory.set(Controller.check_victory(getCurrent_player().getGraph()));
            }

            Controller.switchPlayer(this);
        }
        Controller.switchPlayer(this);
        Display.printVictoryMessage(this);
    }

    public Player getPlayer_1() {
        return player_1;
    }

    public Player getPlayer_2(){
        return player_2;
    }

    Player getCurrent_player(){
        if (player_1.isCurrent()) return player_1;
        else return player_2;
    }

    Player getOther_player(){
        if (!player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getMove_counter() { return move_counter; }
}






