package com.example.leetcode.深度优先算法;

public class LeetCode0200 {

    public static void main(String[] args) {
        char[][] area = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(area));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dps(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    private static boolean dps(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return false;
        }
        grid[i][j] = '0';
        dps(grid, i, j + 1);
        dps(grid, i, j - 1);
        dps(grid, i + 1, j);
        dps(grid, i - 1, j);
        return true;

    }
}