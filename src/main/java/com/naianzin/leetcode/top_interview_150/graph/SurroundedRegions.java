package com.naianzin.leetcode.top_interview_150.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();

        var rows = board.length;
        var cols = board[0].length;

        // Find border 0s
        for (var i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[] {i, 0});
            }
            if (board[i][cols - 1] == 'O') {
                queue.add(new int[] {i, cols - 1});
            }
        }

        for (var j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                queue.add(new int[] {0, j});
            }
            if (board[rows - 1][j] == 'O') {
                queue.add(new int[] {rows - 1, j});
            }
        }

        // BFS border 0s and mark them S
        var directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            var cell = queue.poll();
            board[cell[0]][cell[1]] = 'S';
            for (var direction : directions) {
                var i = cell[0] + direction[0];
                var j = cell[1] + direction[1];
                if (i < 0 || i >= rows || j < 0 || j >= cols) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    queue.add(new int[] {i, j});
                }
            }
        }

        // Mark all remaining 0s to X and saved zeros S back to 0s
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                switch (board[i][j]) {
                    case 'O' -> board[i][j] = 'X';
                    case 'S' -> board[i][j] = 'O';
                }
            }
        }
    }


    public static void main(String[] args) {
        var service = new SurroundedRegions();
        var board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        service.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
