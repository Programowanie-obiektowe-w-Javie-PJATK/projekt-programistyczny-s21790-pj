package pl.s21790.tetris;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    private JLabel statusBar;


    public Tetris() {
        statusBar = new JLabel("0");
        add(statusBar, BorderLayout.SOUTH);

        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.setLocationRelativeTo(null);
        tetris.setVisible(true);
    }
}
