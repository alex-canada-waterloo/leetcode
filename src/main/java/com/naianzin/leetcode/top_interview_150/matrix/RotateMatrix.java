package com.naianzin.leetcode.top_interview_150.matrix;

import java.util.Arrays;

import static java.util.Arrays.deepToString;

// https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int size = matrix.length - 1;
        int layers = matrix.length / 2;
        int temp1;
        int temp2;
        for (int layer = 0; layer < layers; layer++) {
            for (int i = layer; i < size - layer; i++) {
                // top row to right col
                temp1 = matrix[i][size - layer];
                matrix[i][size - layer] = matrix[layer][i];

                // right col to bottom row
                temp2 = matrix[size - layer][size - i];
                matrix[size - layer][size - i] = temp1;

                // bottom row to left col
                temp1 = matrix[size - i][layer];
                matrix[size - i][layer] = temp2;

                // left col to top row
                matrix[layer][i] = temp1;
            }
        }
    }

    public static void main(String[] args) {
        var service = new RotateMatrix();

        var matrix1 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        service.rotate(matrix1);
        System.out.println(Arrays.toString(matrix1[0]));
        System.out.println(Arrays.toString(matrix1[1]));
        System.out.println(Arrays.toString(matrix1[2]));

        var matrix2 = new int[][] {
                {1,   2,  3,  4},
                {5,   6,  7,  8},
                {9,  10,  11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(deepToString(matrix2));
        service.rotate(matrix2);
        System.out.println(Arrays.toString(matrix2[0]));
        System.out.println(Arrays.toString(matrix2[1]));
        System.out.println(Arrays.toString(matrix2[2]));
        System.out.println(Arrays.toString(matrix2[3]));
    }
}
