package com.example.leetcode.回溯;

public class LeetCode0079 {
    public static void main(String[] args) {
        char[][] s = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        System.out.println(exist(s,"ABCESEEEFS"));
    }


    static int[][] s = null;

    public static boolean exist(char[][] board, String word) {
        s = new int [board.length][board[0].length];
        if (board.length == 0 || word.isEmpty()) return false;
        char [] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (dps(board, i, j, wordArr, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dps(char[][] board, int i, int j, char[] word, int index) {
        boolean result = false;
        if (i < 0 || j < 0 || i >= board.length
                || j >= board[0].length
                || word[index] != board[i][j]
                || s[i][j] == 1) return result;
        s[i][j] = 1;
        if (index == word.length - 1) return true;
        result |= dps(board, i - 1, j, word, index + 1);
        result |= dps(board, i + 1, j, word, index + 1);
        result |= dps(board, i, j - 1, word, index + 1);
        result |= dps(board, i, j + 1, word, index + 1);
        if (!result) s[i][j] = 0;
        return result;
    }

}
