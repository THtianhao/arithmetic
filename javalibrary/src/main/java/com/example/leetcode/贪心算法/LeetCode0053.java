package com.example.leetcode.贪心算法;

public class LeetCode0053 {
    public static void main(String [] args) {
        int []a = new int[] {-2,5,-3,-1,-1,2,2,-1,3,-1};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        int maxResult = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            maxResult = Math.max(currentMax, maxResult);
        }
        return maxResult;
    }
}
