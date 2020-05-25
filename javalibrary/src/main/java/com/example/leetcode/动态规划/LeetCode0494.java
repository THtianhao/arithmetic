package com.example.leetcode.动态规划;

import java.util.Arrays;

public class LeetCode0494 {

    public static void main(String [] args) {
        int[] array = new int[]{

                1,1,1,1,1
        };
        
        System.out.println(findTargetSumWays(array, 3));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        if (S < 0) S = -S;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(S) > Math.abs(sum)) return 0;

        int [][] dp = new int[nums.length][2 * sum + 1];
        int start = 0;
        dp[start][sum + nums[start]] = 1;
        dp[start][sum - nums[start]] = 1;
        if (nums[start] == 0){
            Arrays.fill(dp[start] , 1);
        }
        start++;
        for (int i = start; i < nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                int jdiff = j - nums[i] < 0 ? 0 : j - nums[i];
                int jplus = j + nums[i] > 2 * sum ? 0 : j + nums[i];
                dp[i][j] = dp[i - 1][jdiff] + dp[i - 1][jplus];
            }
        }
        return dp[nums.length - 1][ S + sum];
    }
}
