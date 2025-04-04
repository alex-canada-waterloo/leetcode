package com.naianzin.leetcode.top_interview_150.binary_search;

// https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        var rows = matrix.length;
        var cols = matrix[0].length;
        var size = rows * cols;
        var left = 0;
        var right = size - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            var middleRow = middle / cols;
            var middleCol = middle % cols;
            var middleVal = matrix[middleRow][middleCol];
            if (middleVal == target) {
                return true;
            } else if (middleVal > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var service = new Search2DMatrix();
        var matrix = new int[][]{
                { 1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,60},
        };
        System.out.println(service.searchMatrix(matrix, 3) + " Expected: true");


        System.out.println(service.searchMatrix(new int[][] {{1}}, 2) + " Expected: false");
    }
}
