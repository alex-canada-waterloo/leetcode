package com.naianzin.leetcode.top_interview_150.matrix;


import java.util.Arrays;

// https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        var rows = board.length;
        var cols = board[0].length;
        int neighbors;
        int[][] nextState = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                neighbors = countLivingNeighbors(board, row, col);
                switch (neighbors) {
                    case 2 -> nextState[row][col] = board[row][col];
                    case 3 -> nextState[row][col] = 1;
                    default -> nextState[row][col] = 0;
                }
            }
        }
        // Copy nextState into the board
        System.arraycopy(nextState, 0, board, 0, rows);
    }

    private int countLivingNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;
        // top row
        if (row > 0) {
            // left col
            if (col > 0) {
                count += board[row - 1][col - 1];
            }
            // middle col
            count += board[row - 1][col];
            // right col
            if (col + 1 < cols) {
                count += board[row - 1][col + 1];
            }
        }

        // left and right cells
        if (col > 0) {
            count += board[row][col - 1];
        }
        if (col + 1 < cols) {
            count += board[row][col + 1];
        }

        // bottom row
        // top row
        if (row + 1 < rows) {
            // left col
            if (col > 0) {
                count += board[row + 1][col - 1];
            }
            // middle col
            count += board[row + 1][col];
            // right col
            if (col + 1 < cols) {
                count += board[row + 1][col + 1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var service = new GameOfLife();

        var board1 = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        service.gameOfLife(board1);

        System.out.println(Arrays.toString(board1[0]));
        System.out.println(Arrays.toString(board1[1]));
        System.out.println(Arrays.toString(board1[2]));
        System.out.println(Arrays.toString(board1[3]));

        System.out.println("""
                Expected:
                [0, 0, 0],
                [1, 0, 1],
                [0, 1, 1],
                [0, 1, 0]
                """);
    }
}
