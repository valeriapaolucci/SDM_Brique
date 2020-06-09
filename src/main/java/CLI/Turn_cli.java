package CLI;

import Logic.*;

import java.util.ArrayList;

public class Turn_cli {
    private final Game_cli game;
    private final  Coordinates coordinates;

    public Turn_cli(Game_cli game, Coordinates coordinates){
        this.game = game;
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinates> playTurn(){
        game.getBoard().getCell(this.coordinates).setState(game.getCurrent_player().getControl().toState());
        ArrayList<Coordinates> escorts = Rules.escort_rules(game.getBoard(), this.coordinates, game.getCurrent_player().getControl().toState());
        game.getCurrent_player().getGraph().update_graph(this.coordinates, game.getBoard());
        for(Coordinates escort : escorts) {
            game.getCurrent_player().getGraph().update_graph(escort, game.getBoard());
            game.getOther_player().getGraph().restore_graph(escort, game.getBoard());
        }
        escorts.add(coordinates);
        return escorts;
    }





}
