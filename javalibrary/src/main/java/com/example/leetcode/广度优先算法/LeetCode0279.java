package com.example.leetcode.广度优先算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode0279 {

        public static void main(String [] args) {
            System.out.println(numSquares3(4));
        }
         private static int numSquares1(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // bottom case
            dp[0] = 0;

            // pre-calculate the square numbers.
            int max_square_index = (int) Math.sqrt(n) + 1;
            int[] square_nums = new int[max_square_index];
            for (int i = 1; i < max_square_index; ++i) {
                square_nums[i] = i * i;
            }

            for (int i = 1; i <= n; ++i) {
                for (int s = 1; s < max_square_index; ++s) {
                    if (i < square_nums[s])
                        break;
                    dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
                }
            }
            return dp[n];
        }

    static Set<Integer> square_nums = new HashSet<Integer>();

    protected static boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }
        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public static int numSquares2(int n) {
        square_nums.clear();

        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count))
                return count;
        }
        return count;
    }


    public static int numSquares3(int n) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> results = new HashSet<>();
        results.add(n);
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        int deep = 0;
        while (!results.isEmpty()) {
            Set<Integer> resultTmp = new HashSet<>();
            deep++;
            for (int result : results) {
                if (squares.contains(result)) return deep;
                for (int square : squares) {
                    if (result - square > 0){
                        resultTmp.add(result - square);
                    }
                }
            }
            results = resultTmp;
        }
        return deep;
    }

}
