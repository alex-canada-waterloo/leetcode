package com.naianzin.leetcode.top_interview_150.graph;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        var rows = grid.length;
        var cols = grid[0].length;
        var islands = 0;
        for (var currRow = 0; currRow < rows; currRow++) {
            for (var currCol = 0; currCol < cols; currCol++) {
                if (grid[currRow][currCol] == '1') {
                    ++islands;
                    dfs(grid, currRow, currCol);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int currRow, int currCol) {
        var rows = grid.length;
        var cols = grid[0].length;

        if (currRow < 0 || currCol < 0
        || currRow >= rows || currCol >= cols
        || grid[currRow][currCol] == '0') {
            return;
        }
        grid[currRow][currCol] = '0';
        dfs(grid, currRow - 1, currCol);
        dfs(grid, currRow + 1, currCol);
        dfs(grid, currRow, currCol - 1);
        dfs(grid, currRow, currCol + 1);
    }

    public static void main(String[] args) {
        var service = new NumberOfIslands();
        var grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(service.numIslands(grid) + " Expected: 1");
    }
}
