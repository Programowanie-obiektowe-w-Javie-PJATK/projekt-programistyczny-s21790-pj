package pl.s21790.tetris;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    private JLabel statusBar;

    public Tetris() {
        statusBar = new JLabel("0");
        add(statusBar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);
        board.start();
        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tetris();
            }
        });

    }
}
