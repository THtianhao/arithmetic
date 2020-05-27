package com.example.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0139 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak("aaaaaaa", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[wordDict.size()][s.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < wordDict.size(); i++) {
            for (int j = 1; j <= s.length(); j++) {
            }
        }
        return dp[s.length()][s.length()];
    }
}
