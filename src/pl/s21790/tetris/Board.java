package pl.s21790.tetris;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 22;
    private Timer time;
    private boolean fallingEnd = false;
    private boolean start = false;
    private boolean pause = false;
    private int linesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusBar;

    public Board(Tetris tetris) {
        setFocusable(true);
        time = new Timer(400, this);
    }


    public void actionPerformed(ActionEvent actionEvent) {

    }
}
