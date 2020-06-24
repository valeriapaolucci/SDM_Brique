package Logic;

import CommandLine.PlayerInputHandler;
import Data.*;

import java.util.ArrayList;

public interface GameFlow extends Rules {

    default boolean check_victory(Graph graph) {
        return graph.pathFound(225, 226);
    }

    default String getPlayerMove(PlayerInputHandler playerInputHandler, Board board){
        String input;
        while(true) {
            input = playerInputHandler.getInput(playerInputHandler.getCoordinate_request_msg(), playerInputHandler.getCoordinate_err_msg(), playerInputHandler.getCoordinate_pattern());
            if (input.equals("res")) return input;
            else {
                Coordinates coordinates = new Coordinates(15 - Integer.parseInt(input.substring(1)), input.charAt(0) - 'a');
                if (!board.areEmpty(coordinates)) {
                    System.out.println("Position already occupied.");
                } else break;
            }
        }
        return input;
    }

    default ArrayList<Coordinates> make_move(Board board, Coordinates coordinates, Player current, Player other) {
        board.getCell(coordinates).setState(current.getControl().toState());
        ArrayList<Coordinates> escorts = escort_rules(board, coordinates, current.getControl().toState());
        current.getGraph().update_graph(coordinates, board);
        for (Coordinates escort : escorts) {
            current.getGraph().update_graph(escort, board);
            other.getGraph().restore_graph(escort, board);
        }
        escorts.add(coordinates);
        return escorts;
    }
}
