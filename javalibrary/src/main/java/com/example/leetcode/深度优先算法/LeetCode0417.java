package com.example.leetcode.深度优先算法;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0417 {

    public static void main(String [] args) {
        int[][] area = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(area));
    }

    private static List<List<Integer>> result = null;
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        result = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int [][] exist = new int[matrix.length - 1][matrix[0].length - 1];
                if(dps(matrix, exist, i, j) == (left | right)) {
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(i);
                    item.add(j);
                    result.add(item);
                }
            }
        }
        return result;
    }

    static int left = 0x1;
    static int right = 0x2;
    private static int dps(int[][] matrix, int[][] exist,int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || exist[i][j] == 1) {
            return 0;
        }
        exist[i][j] = 1;
        int result = 0;
        if (i == 0 || j == 0){
            return left;
        }
        if (i == matrix.length - 1 || j == matrix.length - 1){
            return right;
        }
        result |= dps(matrix, exist, i - 1, j);
        result |= dps(matrix, exist, i + 1, j);
        result |= dps(matrix, exist, i, j - 1);
        result |= dps(matrix, exist, i, j + 1);
        return result;
    }
}
