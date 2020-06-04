package Logic;

import java.util.ArrayList;

public class Rules  {

    public static ArrayList<Coordinates> escort_rules(Board board, Coordinates c, State piece) {
        Cell cell = board.getCell(c);
        ArrayList<Coordinates> escorts = new ArrayList<>();
        ArrayList<Cell> escort_of = get_escorts(board, c);
        escort_of.forEach(current_escort->{
            ArrayList<Cell> escort_of_current = get_escorts(board, current_escort.getCoordinates());
            escort_of_current.forEach(value->{if(value.getState().equals(piece) && !value.equals(cell)){
                board.getCell(current_escort.getCoordinates()).setState(piece);
                escorts.add(current_escort.getCoordinates());
            }});
        });

        return escorts;
    }

    private static Cell extract_specific_cell(Board board, int i, int j) {
        Coordinates esc1 = new Coordinates(i, j);
        if (esc1.areValid()) {
            return board.getCell(esc1);
        } else {
            return null;
        }
    }


    public static ArrayList<Cell> get_escorts(Board board, Coordinates c) {
        ArrayList<Cell> res = new ArrayList<>();
        Cell cell = board.getCell(c);
        if (cell.getPieceColor() == PieceColor.WHITE) {
            if(Coordinates.valid_coordinates(c.getRow()-1,c.getCol()))
                res.add(extract_specific_cell(board, c.getRow() - 1, c.getCol()));
            if (Coordinates.valid_coordinates(c.getRow(),c.getCol()-1))
                res.add(extract_specific_cell(board, c.getRow(), c.getCol() - 1));
        } else {
            if (Coordinates.valid_coordinates(c.getRow()+1,c.getCol()))
                res.add(extract_specific_cell(board, c.getRow() + 1, c.getCol()));
            if (Coordinates.valid_coordinates(c.getRow(),c.getCol()+1))
                res.add(extract_specific_cell(board, c.getRow(), c.getCol() + 1));
        }
        return res;
    }


    public static void apply_pie_rule(Game game) {
        Controller.swapControl(game.getPlayer_1(), game.getPlayer_2());
        Controller.swapGraphs(game.getPlayer_1(), game.getPlayer_2());
    }


    public static void Pie_rule_cli(Player p1, Player p2) {
        PieceColor temp = p1.getControl();
        p1.setControl(p2.getControl());
        p2.setControl(temp);
    }
}




