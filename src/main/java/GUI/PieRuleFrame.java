package GUI;

import Logic.AI_Logic;
import Logic.Controller;
import Logic.Game;
import Logic.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PieRuleFrame {

    JButton yes, no;

    public PieRuleFrame(JFrame board, Game game, GameFrame gameFrame) {
        JFrame pieRule = new JFrame("Pie Rule");
        pieRule.setLayout(new FlowLayout());
        pieRule.setSize(260,120);
        pieRule.setLocationRelativeTo(null);
        pieRule.setResizable(false);
        pieRule.setAlwaysOnTop(true);

        pieRule.add(new JLabel("Do you want to apply the Pie Rule?"));
        yes = new JButton("Yes");
        pieRule.add(yes);

        yes.addActionListener(actionEvent -> {
            Rules.apply_pie_rule(game);
            game.pieRule = true;
            Controller.switchPlayer(game);

            if(!gameFrame.isMultiplayer) gameFrame.boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            gameFrame.setEnabled(true);
            pieRule.dispose();
        });

        no = new JButton("No");
        pieRule.add(no);

        no.addActionListener(actionEvent -> {
            gameFrame.setEnabled(true);
            pieRule.dispose();
        });


        pieRule.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pieRule.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                board.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                board.setEnabled(true);
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
                board.setEnabled(true);
            }
        });

        pieRule.setVisible(true);
    }
}
