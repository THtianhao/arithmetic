package com.example.leetcode.动态规划;

import java.util.Arrays;

public class LeetCode0322 {
    public static void main(String [] args) {
        int[] array = new int[]{

                1,2,5

        };
        System.out.println(coinChange(array, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[][] dp = new int[coins.length][amount + 1];


        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
            if (j - coins[0] >= 0 && dp[0][j - coins[0]] != Integer.MAX_VALUE) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount ; j++) {
                int tmp = Integer.MAX_VALUE;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    tmp = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], tmp);
            }
        }
        if (dp[coins.length - 1][amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[coins.length - 1][amount];
    }
}
