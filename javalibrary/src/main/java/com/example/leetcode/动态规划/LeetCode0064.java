package com.example.leetcode.动态规划;

public class LeetCode0064 {
    public static void main(String[] args) {
        int [][ ]array = new int[][]{{1,2,5},{3,2,1}};
        System.out.println(minPathSum(array));
    }

    public static int minPathSum(int[][] grid) {
        return minPath(grid, 0, 0, 0);
    }

    public static int minPath(int[][] grid, int row, int col, int last) {
        if (row == grid.length || col == grid[0].length ) return Integer.MAX_VALUE;
        int cur = grid[row][col] + last;
        if (row == grid.length - 1 && col == grid[0].length - 1) return cur;
        return Math.min(
                minPath(grid, row + 1, col, cur),
                minPath(grid, row, col + 1, cur)
        );
    }
}
