package pl.s21790.tetris;
import pl.s21790.tetris.Shape.Blocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 22;
    private static final Color[] COLORS = {new Color(0,0,0),
            new Color(30, 180, 250),
            new Color(100, 88,77),
            new Color(100, 10, 76),
            new Color(16, 0, 195),
            new Color(0, 255, 90),
            new Color(255, 6, 69),
            new Color(255, 60, 203)};
    private Timer time;
    private boolean fallingEnd = false;
    private boolean start = false;
    private boolean isStop = false;
    private int linesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusBar;
    private Shape curBlock;
    private Blocks[] board;

    public Board(Tetris tetris) {
        setFocusable(true);
        curBlock = new Shape();
        time = new Timer(400, this);
        statusBar = tetris.getStatusBar();
        board = new Blocks[WIDTH * HEIGHT];
        clearBoard();
        addKeyListener(new tetrisAdapter());
    }
    public int cubeWidth() {
        return (int) getSize().getWidth() / WIDTH;
    }

    public int cubeHeight() {
        return (int) getSize().getHeight() / HEIGHT;
    }

    public Blocks shapeAt(int x, int y) {
        return board[y * WIDTH + x];
    }

    private void clearBoard() {
        for(int i = 0; i < HEIGHT * WIDTH; i++) {
            board[i] = Blocks.emptyBlock;
        }
    }

    private void drawCube(Graphics g, int x, int y, Blocks shape) {
        Color color = COLORS[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, cubeWidth() - 2, cubeHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + cubeHeight() - 1, x, y);
        g.drawLine(x, y, x + cubeWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + cubeHeight() - 1, x + cubeWidth(), y + cubeHeight() - 1);
        g.drawLine((x + cubeWidth() - 1), y + cubeHeight() - 1, x + cubeWidth() - 1, y + 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();

        int boardTop = (int) size.getHeight() - HEIGHT * cubeHeight();
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = 0; j < WIDTH; ++j) {
                Blocks shape = shapeAt(j, HEIGHT - i - 1);
                if(shape != Blocks.emptyBlock) {
                    drawCube(g, j * cubeWidth(), boardTop + i * cubeHeight(), shape);
                }
            }
        }
        if(curBlock.getShape() != Blocks.emptyBlock) {
            for(int i = 0; i < 4; i++) {
                int x = curX + curBlock.x(i);
                int y = curY - curBlock.y(i);
                drawCube(g, x * cubeWidth(), boardTop + (HEIGHT - y - 1) * cubeHeight(), curBlock.getShape());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

























