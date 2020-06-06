package Logic;

import java.util.Arrays;

public class Coordinates {
    private int row;
    private int col;

    public Coordinates(int r, int c) {
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public boolean areValid() {
        int[] x = new int[]{this.row, this.col};
        return (Arrays.stream(x).filter(z -> z < 15).filter(z -> z >= 0).count() == 2);
    }



    public void setCoordinates(int r, int c) {
        row = r;
        col = c;
    }
}
