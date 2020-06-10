package pl.s21790.tetris;

import java.util.Random;

public class Shape {

    enum Blocks {
        emptyBlock(new int[][] {{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
        Iblock(new int[][] {{0, -1}, {0, 0}, {0, 1}, {0, 2}}),
        Tblock(new int[][] {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}),
        Oblock(new int[][] {{0, 0}, {1, 0}, {0, 1}, {1, 1}}),
        Lblock(new int[][] {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}),
        Jblock(new int[][] {{1, -1}, {0, -1}, {0, 0}, {0, 1}}),
        Sblock(new int[][] {{0, -1}, {0, 0}, {1, 0}, {1, 1}}),
        Zblock(new int[][] {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}),
        ;
        public int[][] coordinates;
        private Blocks(int[][] coordinates) {
            this.coordinates = coordinates;
        }
    }

    private Blocks blockShape;
    private int[][] coordinates;

    public Shape() {
        coordinates = new int[4][2];
        setShape(Blocks.emptyBlock);
    }

    public void setShape(Blocks shape) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 2; ++j) {
                coordinates[i][j] = shape.coordinates[i][j];
            }
        }
        blockShape = shape;
    }

    private void setX(int pointer, int x) {
        coordinates[pointer][0] = x;
    }

    private void setY(int pointer, int y) {
        coordinates[pointer][1] = y;
    }

    public int x(int pointer) {
        return coordinates[pointer][0];
    }

    public int y(int pointer) {
        return coordinates[pointer][1];
    }
    public Blocks getShape() {
        return blockShape;
    }

    public void randomShapeGenerator() {
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % 7 + 1;
        Blocks[] values = Blocks.values();
        setShape(values[x]);
    }

    public int minX() {
        int min = coordinates[0][0];
        for(int i = 0; i < 4; i++) {
            min = Math.min(min, coordinates[i][0]);
        }
        return min;
    }

    public int minY() {
        int min = coordinates[0][1];
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, coordinates[i][1]);
        }
        return min;
    }

}
