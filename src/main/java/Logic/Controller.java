package Logic;

import CLI.Game_cli;

public class Controller {

    public static void switchPlayer(Game game) {
        if (game.getPlayer_1().isCurrent()) {
            game.getPlayer_1().setCurrent(false);
            game.getPlayer_2().setCurrent(true);
        } else {
            game.getPlayer_1().setCurrent(true);
            game.getPlayer_2().setCurrent(false);
        }
    }


    public static void switchPlayer(Game_cli game) {

        if (game.getPlayer_1().isCurrent()) {
            game.getPlayer_1().setCurrent(false);
            game.getPlayer_2().setCurrent(true);
        } else {
            game.getPlayer_1().setCurrent(true);
            game.getPlayer_2().setCurrent(false);
        }
    }

    public static void swapGraphs(Player p1, Player p2) {
        Graph temp = p1.getGraph();
        p1.setGraph(p2.getGraph());
        p2.setGraph(temp);
    }


    public static boolean check_victory(Graph graph) {
        return graph.pathFound(225, 226);
    }

    public static boolean areEmpty(Board board, Coordinates coordinates) {
    return board.getCell(coordinates).getState() == State.EMPTY;
    }

    public static void swapControl(Player p1, Player p2) {
        PieceColor temp = p1.getControl();
        p1.setControl(p2.getControl());
        p2.setControl(temp);
    }


    public static void apply_pie_rule(Game_cli game, boolean pie_bool) {

        if (pie_bool) {
            Rules.Pie_rule_cli(game.getPlayer_1(), game.getPlayer_2());
            swapGraphs(game.getPlayer_1(), game.getPlayer_2());
        } else {
            switchPlayer(game);
        }
    }


}

