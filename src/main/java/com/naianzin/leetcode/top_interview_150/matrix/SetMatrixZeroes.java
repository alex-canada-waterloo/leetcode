package com.naianzin.leetcode.top_interview_150.matrix;


import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // check first row and first col if they contain any zeroes
        boolean firstRowContainsZero = false;
        boolean firstColumnContainsZero = false;
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }

        // Iterate over inner matrix, if cell is 0, set 0 to first cell in the row and first cell in the column
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // Iterate over first row, if cell is 0, set 0 to the whole column
        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Iterate over first column, if cell is 0, set 0 to the whole row
        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // finally set first col or row to zeroes if required
        if (firstColumnContainsZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }

        if (firstRowContainsZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
    }

    public static void main(String[] args) {

        var service = new SetMatrixZeroes();

        var matrix1 = new int[][] {
                {1,1,1, 1},
                {1,0,1, 1},
                {1,1,1, 0},
                {1, 1, 1, 1}
        };

        service.setZeroes(matrix1);

        System.out.println(Arrays.toString(matrix1[0]));
        System.out.println(Arrays.toString(matrix1[1]));
        System.out.println(Arrays.toString(matrix1[2]));
        System.out.println(Arrays.toString(matrix1[3]));
    }
}
