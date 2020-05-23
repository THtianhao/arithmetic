package com.example.leetcode.动态规划;

import java.util.Arrays;

public class LeetCode0300and贪心 {
    public static void main(String [] args) {
        int[] array = new int[]{


                -2, -1
        };
        System.out.println(lengthOfLIS(array));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] array = new int[nums.length];
        Arrays.fill(array, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    array[i] = Math.max(array[j]+ 1, array[i]);
                }
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
