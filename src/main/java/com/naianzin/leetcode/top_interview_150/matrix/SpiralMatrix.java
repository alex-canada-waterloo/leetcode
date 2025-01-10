package com.naianzin.leetcode.top_interview_150.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

// https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
public class SpiralMatrix {


    public static void main(String[] args) {
        var servie = new SpiralMatrix();
        System.out.println(servie.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }) + "Expected: [1,2,3,4,8,12,11,10,9,5,6,7]");

        System.out.println(servie.spiralOrder(new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        }) + " Expected: 1, 2, 4, 6, 5, 3");

        System.out.println(servie.spiralOrder(new int[][]{
                {1},
                {2},
                {3}
        }) + " Expected: 1, 2, 3");

        System.out.println(servie.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16},
                {17,18,19,20},
                {21,22,23,24}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowsIterationsLimit = (Math.min(rows, cols) + 1) / 2;
        var result = new ArrayList<Integer>(rows * cols);

        for (int currentLayer = 0; currentLayer < rowsIterationsLimit; currentLayer++) {
            // Top row
            for (int colP = currentLayer; colP < (cols - currentLayer); colP++) {
                result.add(matrix[currentLayer][colP]);
            }

            // Right col
            for (int rowP = currentLayer + 1;
                 rowP < rows - currentLayer;
                 rowP++
            ) {
                result.add(matrix[rowP][cols - 1 - currentLayer]);
            }

            // Bottom row
            if (rows - 1 - currentLayer != currentLayer) {
                for (int colP = cols - currentLayer - 2;
                     colP >= currentLayer;
                     colP--
                ) {
                    result.add(matrix[rows - currentLayer - 1][colP]);
                }
            }

            // Left col
            if (currentLayer != cols - 1 - currentLayer) {
                for (int rowP = rows - 2 - currentLayer;
                     rowP >= currentLayer + 1;
                     rowP--
                ) {
                    result.add(matrix[rowP][currentLayer]);
                }
            }
        }

        return result;
    }
}
