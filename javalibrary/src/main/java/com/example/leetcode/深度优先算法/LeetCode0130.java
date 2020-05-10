package com.example.leetcode.深度优先算法;

public class LeetCode0130 {
    public static void main(String[] args) {
        char[][] area = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(area);
        System.out.println();
    }


    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (dps(board, i, j)){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private static boolean dps(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] == 'X') return true;
        boolean truse = true;
        truse &= dps(board, i + 1, j);
        truse &= dps(board, i - 1, j);
        truse &= dps(board, i, j + 1);
        truse &= dps(board, i, j - 1);
        return truse;
    }
}
