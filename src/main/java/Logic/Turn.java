package Logic;

import java.util.ArrayList;

public class Turn {

    private final Game game;
    private final Coordinates coordinates;


    public Turn(Game game, Coordinates coordinates){
        this.game = game;
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinates> playTurn(){
        game.board.getCell(coordinates).setState(game.getCurrent_player().getControl().toState());
        ArrayList<Coordinates> escorts = Rules.escort_rules(game.getBoard(), coordinates, game.getCurrent_player().getControl().toState());
        game.getCurrent_player().getGraph().update_graph(coordinates, game.getBoard());

        for(Coordinates escort : escorts) {
            game.getCurrent_player().getGraph().update_graph(escort, game.getBoard());
            game.getOther_player().getGraph().restore_graph(escort, game.getBoard());
        }
        escorts.add(coordinates);
        return escorts;
    }
}
