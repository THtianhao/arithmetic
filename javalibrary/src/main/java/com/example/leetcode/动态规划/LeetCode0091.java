package com.example.leetcode.动态规划;

public class LeetCode0091 {
    public static void main(String [] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        if (s.charAt(0) == '0') return 0;
        int[] list = new int[s.length() + 1];
        list[0] = 1;
        list[1] = chars[0] == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (chars[i - 1] != '0'){
                list[i] += list[i - 1];
            }

            if (chars[i - 2] == '0') continue;

            int n = (chars[i - 1] - '0') + (chars[i - 2] - '0') * 10;
            if (n <= 26){
                list[i] +=  list[i - 2];
            }

        }
        return list[s.length()];
    }
}
