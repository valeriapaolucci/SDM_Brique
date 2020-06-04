package GUI;

import Logic.*;
import Logic.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameFrame extends JFrame implements MouseListener {

    boolean isMultiplayer;
    JFrame board;
    String player1Name, player2Name;
    Dimension dimension;
    Game game;
    ArrayList<CellPanel> CellPanels = new ArrayList<>();

    GameFrame(boolean isMultiplayer){

        this.player1Name = Settings.getPlayer1Name();
        this.player2Name = Settings.getPlayer2Name();

        this.isMultiplayer = isMultiplayer;
        this.dimension = Settings.getResolution();

        if (!isMultiplayer){
            board = new JFrame(player1Name + " VS. AI!");
            game = new Game(new Player(Settings.getPlayer1PieceColor(), player1Name), new Player(Settings.getPlayer2PieceColor()), false);

        } else {
            board = new JFrame(player1Name + " VS. " + player2Name + "!");
            game = new Game(new Player(PieceColor.BLACK, player1Name), new Player(PieceColor.WHITE, player2Name), true);
        }
        System.out.println(game.player_1.getName() + "control " + game.player_1.getControl());
        System.out.println(game.player_2.getName() + "control " + game.player_2.getControl());
        System.out.println(game.getCurrent_player().getName() + " is active");

        dimension.setSize(dimension.width + 14, dimension.height + 37);
        board.setSize(dimension);
        board.setResizable(false);
        board.setBackground(java.awt.Color.BLACK);
        board.setLocationRelativeTo(null);

        board.setLayout(new GridLayout(15,15, 0,0));

        for(int i = 0; i < 15; i++){
            for (int j = 0; j < 15 ; j++) {
                this.CellPanels.add(new CellPanel(i,j));
                board.add(CellPanels.get(i * 15 + j));
            }
        }

        board.addMouseListener(this);
        board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (game.getPlayer_1().getControl()==PieceColor.WHITE && !isMultiplayer) {
            boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            new PieRuleFrame(board, game, this);
        }

        board.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });

        board.setVisible(true);
    }

    void boardCellClick(Coordinates coordinates){

        game.increaseMoveCounter();
        Turn turn = new Turn(this.game, coordinates);
        ArrayList<Coordinates> toDraw = turn.playTurn();
        for(Coordinates coordinate : toDraw){
            CellPanels.get(coordinate.getRow() * 15 + coordinate.getCol()).setState(game.getCurrent_player().getControl());
            CellPanels.get(coordinate.getRow() * 15 + coordinate.getCol()).repaint();
        }
        if (isMultiplayer && game.getMove_counter()==1) new PieRuleFrame(board, game,this);
        Controller.switchPlayer(this.game);

        System.out.println("move made.. now:");
        System.out.println(game.player_1.getName() + "control " + game.player_1.getControl());
        System.out.println(game.player_2.getName() + "control " + game.player_2.getControl());
        System.out.println(game.getCurrent_player().getName() + " is active/n");
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Coordinates coordinates = new Coordinates((mouseEvent.getY()-30)/(Settings.getResolution().height/15), (mouseEvent.getX()-7)/(Settings.getResolution().width/15));
        if(Controller.areEmpty(game.getBoard(), coordinates)) {
            boardCellClick(new Coordinates((mouseEvent.getY()-30)/(Settings.getResolution().height/15), (mouseEvent.getX()-7)/(Settings.getResolution().width/15)));
            if(!isMultiplayer && !Controller.check_victory(game.getOther_player().getGraph())) {
                boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            }
            if(Controller.check_victory(game.getOther_player().getGraph())){
                new VictoryFrame(game.getOther_player().getName(), board);
                board.setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
