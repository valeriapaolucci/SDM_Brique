package GUI;

import Logic.PieceColor;
import Logic.Settings;
import Logic.State;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    JPanel cell;
    Dimension dimension = new Dimension(Settings.getResolution().width/15, Settings.getResolution().height/15);
    int row, col;
    State state = State.EMPTY;
    double ratio = Settings.getRatio();

    public CellPanel(int i, int j) {
        this.row = i;
        this.col = j;
        cell = new JPanel();
        cell.setSize(dimension);
        cell.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor((row + col) % 2 == 0 ? new java.awt.Color(78, 33, 8) : new java.awt.Color(227, 195, 173));
        g.fillRect(0, 0, dimension.width, dimension.height);
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(0, 0, dimension.width, dimension.height);

        if(state == State.W_PIECE){
            drawPiece( (int) (dimension.height * (1 - ratio) / 2), (int) (dimension.height * (1 - ratio) / 2), new java.awt.Color(0xF1EBE6), dimension.height, g);
        } else if (state == State.B_PIECE){
            drawPiece( (int) (dimension.height * (1 - ratio) / 2), (int) (dimension.height * (1 - ratio) / 2), new java.awt.Color(0x000000), dimension.height, g);
        }
    }

    public void setState(PieceColor control) {
        this.state = control == PieceColor.WHITE ? State.W_PIECE : State.B_PIECE;
    }

    public void drawPiece(int i, int j, java.awt.Color color, int cell_dim, Graphics g) {
        g.setColor(color);
        g.fillOval(i, j, (int) (cell_dim * ratio), (int) (cell_dim * ratio));
        g.setColor(new java.awt.Color(0x000000));
        g.drawOval(i, j, (int) (cell_dim * ratio), (int) (cell_dim * ratio));
    }
}
