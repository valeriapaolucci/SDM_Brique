package BriqueTest;

import Logic.*;
import org.junit.Test;
import org.junit.Assert;

import static junit.framework.TestCase.assertTrue;

public class AI_LogicTest {

    @Test
    public void chooseRandomCoordinatesTest(){
        Board board = new Board();
        Coordinates coordinates = AI_Logic.chooseRandomCoordinates(board);
        assertTrue(coordinates.getRow()<15 && coordinates.getRow()>=0);
        assertTrue(coordinates.getCol()<15 && coordinates.getCol()>=0);
    }


}
