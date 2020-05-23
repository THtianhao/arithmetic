package com.example.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0297 {
 public static void main(String [] args) {
     System.out.println(numSquares(12));
 }

    public static int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int[] minArray = new int[n + 1];
        for (int i = 1; i * i < n; i++){
            list.add(i * i);
        }
        for (int i = 1; i <= n; i++) {
            int min = 0;
            for (int item : list) {
                if (item > i) break;
                min = Math.min(minArray[i - item] + 1, min);
            }
            minArray[i] = min;
        }
        return minArray[n];
    }
}