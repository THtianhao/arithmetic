package com.example.leetcode.深度优先算法;

public class LeetCode0695 {
    public static void main(String[] args) {
        int[][] area = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(area));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, dps(grid, i, j));
            }
        }
        return max;
    }

    private static int dps(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        area += dps(grid, x, y + 1);
        area += dps(grid, x, y - 1);
        area += dps(grid, x + 1, y);
        area += dps(grid, x - 1, y);
        return area;

    }
}
