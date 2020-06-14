package BriqueTest;

import Data.*;
import Logic.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;



public class RulesTest implements Rules{




    @Test
    public void Check_pieRule() {
        Player p1 = new Player(PieceColor.BLACK, "p1");
        Player p2 = new Player( PieceColor.WHITE, "p2");
        Game game = new Game(p1,p2);
        game.apply_pie_rule(p1, p2);
        Assert.assertEquals(PieceColor.WHITE,p1.getControl());
        Assert.assertEquals(PieceColor.BLACK,p2.getControl());
    }


    @Test
    public void check_get_escorts(){
        Coordinates white_c = new Coordinates(1,3);
        ArrayList<Cell> white_escorts = get_escorts(new Board() ,white_c);
        check_coordinates(white_escorts,0,3,1,2);
        Coordinates black_c = new Coordinates(1,4);
        ArrayList<Cell> black_escorts = get_escorts(new Board(), black_c);
        check_coordinates(black_escorts,2,4,1,5);
    }

    @Test
    public void check_escort_rule() {
        Coordinates c = new Coordinates(1, 3);
        Check_esc(c, State.B_PIECE);
        Coordinates d = new Coordinates(1, 2);
        Check_esc(d, State.B_PIECE);
    }




    public void check_coordinates(ArrayList<Cell> escorts,int row_0,int col_0,int row_1,int col_1){
        Assert.assertEquals(row_0,escorts.get(0).getCoordinates().getRow());
        Assert.assertEquals(col_0,escorts.get(0).getCoordinates().getCol());
        Assert.assertEquals(row_1,escorts.get(1).getCoordinates().getRow());
        Assert.assertEquals(col_1,escorts.get(1).getCoordinates().getCol());


    }

    public void Check_esc(Coordinates c, State state) {
        Board board = new Board();
        board.getCell(c).setState(state);
        Coordinates c2 = GetRightCoordinateToApplyEscortRule(c);
        modify_board(board,c,c2,state);
        ArrayList<Enum<State>> StateToBeControlled = GetCoordinatesOfStatesModifiedByEscortRule(c,board);
        Assert.assertEquals(state, StateToBeControlled.get(0));
        Assert.assertEquals(State.EMPTY, StateToBeControlled.get(1));
    }


    public void modify_board(Board board,Coordinates c ,Coordinates c2, State state){
        board.getCell(c2).setState(state);
        ArrayList<Coordinates> x = escort_rules(board, c, state);
    }


    public Coordinates GetRightCoordinateToApplyEscortRule(Coordinates c){
        if ((c.getCol()+c.getRow())%2==0){
            Coordinates res = new Coordinates(c.getRow() + 1, c.getCol() - 1);
            if(res.areValid()) return res;
            else return null;
        }
        else {
            Coordinates res = new Coordinates(c.getRow() - 1, c.getCol() + 1);
            if(res.areValid()) return res;
            else return null;
        }
    }

    public ArrayList<Enum<State>> GetCoordinatesOfStatesModifiedByEscortRule(Coordinates c, Board board){
        ArrayList<Enum<State>> res = new ArrayList<>();
        if((c.getCol()+c.getRow())%2==0){
            res.add(board.getCell(new Coordinates(c.getRow(), c.getCol() - 1)).getState());
            res.add(board.getCell(new Coordinates(c.getRow() - 1, c.getCol())).getState());
        }
        else{
            res.add(board.getCell(new Coordinates(c.getRow(), c.getCol() + 1)).getState());
            res.add(board.getCell(new Coordinates(c.getRow() + 1, c.getCol())).getState());
        }
        return res;
    }
}
