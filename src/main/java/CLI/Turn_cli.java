package CLI;

import Logic.AI_Logic;
import Logic.Controller;
import Logic.Coordinates;
import Logic.Rules;

import java.util.ArrayList;

public class Turn_cli {
    private final Game_cli game;

    public Turn_cli(Game_cli game){
        this.game = game;
    }

    public void  playTurn(){

        Coordinates coordinates = null;

        if(game.getCurrent_player().isHuman()) {
            boolean valid_move = false;
            while (!valid_move) {
                coordinates = IO_Interface.getCoordinates(game.getCurrent_player());
                if(game.getCurrent_player().isResigned()) return;
                valid_move = Controller.areEmpty(game.getBoard(), coordinates);
            }
        } else {
            coordinates = AI_Logic.chooseRandomCoordinates(game.getBoard());
        }


        game.getBoard().getCell(coordinates).setState(game.getCurrent_player().getControl().toState());
        ArrayList<Coordinates> escorts = Rules.escort_rules(game.getBoard(), coordinates, game.getCurrent_player().getControl().toState());

        game.getCurrent_player().getGraph().update_graph(coordinates, game.getBoard());

        for(Coordinates escort : escorts) {
            game.getCurrent_player().getGraph().update_graph(escort, game.getBoard());
            game.getOther_player().getGraph().restore_graph(escort, game.getBoard());
        }

    }





}
