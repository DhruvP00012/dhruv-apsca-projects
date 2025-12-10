package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    private int[][] board;

    public GameOfLife(int x, int y) {
        this.board = new int[x][y];
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }
    }

    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (i + x < board.length && j + y < board.length) {
                    board[i + x][j + y] = data[i][j];
                }
            }
        }
    }

    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    public void step() {
        print();
        int[][] nextboard = new int[board.length][board.length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                int aliveNeighbors = countNeighbors(x, y);

                if (board[x][y] == 1) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        nextboard[x][y] = 0;
                    } else {
                        nextboard[x][y] = 1;
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        nextboard[x][y] = 1;
                    } else {
                        nextboard[x][y] = 0;
                    }
                }
            }
        }
        this.board = nextboard;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; 

                count += get(x + dx, y + dy);
            }
        }
        return count;
    }

    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board.length;
        int wrapX = (x % xLimit + xLimit) % xLimit;
        int wrapY = (y % yLimit + yLimit) % yLimit;
        return board[wrapX][wrapY];
    }

    public int[][] get() {
        return board;
    }

    public void print() {
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
