package com.example.leetcode.回溯;

public class LeetCode0037 {
    private static boolean isFinish;

    public static void main(String[] args) {
        char[][] array = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(array);
        System.out.println();
    }

    public static void solveSudoku(char[][] boardd) {
        board = boardd;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int item = (int) board[i][j] - '0';
                    check(i, j, item);
                }
            }
        }
        backtrack(0, 0);

    }


    private static boolean[][] row = new boolean[9][10];
    private static boolean[][] col = new boolean[9][10];
    private static boolean[][] local = new boolean[9][10];
    private static char[][] board = new char[0][0];

    public static void check(int i, int j, int item) {
        int box = i / 3 * 3 + j / 3;
        row[i][item] = true;
        col[j][item] = true;
        local[box][item] = true;
        board[i][j] = (char) (item + '0');
    }

    public static boolean isExist(int i, int j, int item) {
        int box = i / 3 * 3 + j / 3;
        return row[i][item] || col[j][item] || local[box][item];
    }

    public static void backtrack(int row, int col) {

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (!isExist(row, col, i)) {
                    check(row, col, i);
                    moveToNext(row, col, board[row][col]);
                    if (isFinish) return;
                    moveToBefore(row, col, board[row][col]- '0');
                }
            }
        } else {
            moveToNext(row, col, board[row][col]);
        }
    }


    public static void moveToBefore(int i, int j, int item) {
        int box = i / 3 * 3 + j / 3;
        row[i][item] = false;
        col[j][item] = false;
        local[box][item] = false;
        board[i][j] = '.';
    }


    public static void moveToNext(int row, int col, int item) {
        if (row == 8 && col == 8) {
            isFinish = true;
            return ;
        }
        int coltmp = col + 1;
        if (coltmp > 8) {
            backtrack(row + 1, 0);
        } else {
            backtrack(row , col + 1);
        }
    }
}