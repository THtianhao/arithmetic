package com.example.leetcode.深度优先算法;

public class LeetCode0547 {

    public static void main(String[] args) {
        int[][] area = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(area));
    }

        public static int findCircleNum(int[][] M) {
            if (M == null || M.length == 0) return 0;
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[0].length; j++) {
                    if (M[i][j] == 1) {
                        dps(M, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private static void dps(int[][] a, int i, int j) {
            if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0) {
                return;
            }
            a[i][j] = 0;
            dps(a, i, j + 1);
            dps(a, i, j - 1);
            dps(a, i + 1, j);
            dps(a, i - 1, j);
        }

    }
