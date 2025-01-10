package com.naianzin.leetcode.top_interview_150.matrix;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        char[] tempArea = new char[9];
        boolean isValid;

        // Valid rows
        for (int row = 0; row < 9; row++) {
            isValid = checkSudokuArea(board[row]);
            if (!isValid) {
                return false;
            }
        }

        // Valid columns
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                tempArea[row] = board[row][col];
            }
            isValid = checkSudokuArea(tempArea);
            if (!isValid) {
                return false;
            }
        }


        // Valid squares
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        tempArea[row * 3 + col] = board[i + row][j+ col];
                    }
                }
                isValid = checkSudokuArea(tempArea);
                if (!isValid) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkSudokuArea(char[] area) {
        int[] chars = new int[10];
        int index;
        for (char ch : area) {
            index = switch (ch) {
                case '.' -> 0;
                case '1' -> 1;
                case '2' -> 2;
                case '3' -> 3;
                case '4' -> 4;
                case '5' -> 5;
                case '6' -> 6;
                case '7' -> 7;
                case '8' -> 8;
                case '9' -> 9;
                default -> -1;
            };
            if (index == -1) {
                return false;
            }
            if (index > 0) {
                if (chars[index] == 1) {
                    return false;
                } else {
                    chars[index] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var service = new ValidSudoku();

        System.out.println(service.isValidSudoku(new char[][] {
                new char[] {'5', '3', '.',   '.', '7', '.',  '.', '.', '.'},
                new char[] {'6', '.', '.',   '1', '9', '5',  '.', '.', '.'},
                new char[] {'.', '9', '8',   '.', '.', '.',  '.', '6', '.'},

                new char[] {'8', '.', '.',   '.', '6', '.',  '.', '.', '3'},
                new char[] {'4', '.', '.',   '8', '.', '3',  '.', '.', '1'},
                new char[] {'7', '.', '.',   '.', '2', '.',  '.', '.', '6'},

                new char[] {'.', '6', '.',   '.', '.', '.',  '2', '8', '.'},
                new char[] {'.', '.', '.',   '4', '1', '9',  '.', '.', '5'},
                new char[] {'.', '.', '.',   '.', '8', '.',  '.', '7', '9'}
        }));
        
    }
}
