package com.example.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode0452 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(findMinArrowShots(arr));
    }

    static class MyCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length <= 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, new MyCompare());
        int result = 1;
        int left = -1;
        int right = 10 * 10 * 10 * 10;
        for (int[] item : points) {
            if (item[0] >= left) {
                left = item[0];
            }
            if (item[1] <= right) {
                right = item[1];
            }
            if (left > right) {
                result++;
                left = item[0];
                right = item[1];
            }
        }
        return result;
    }

    //代码更少解法
    public static int findMinArrowShots2(int[][] points) {
        if (points.length <= 0) {
            return 0;
        }
        Arrays.sort(points, new MyCompare());
        int result = 1;
        int left, right = points[0][1];
        for (int [] item : points) {
            left = item[0];
            if (left > right){
                result++;
                right = item[1];
            }
        }
        return result;
    }
}
