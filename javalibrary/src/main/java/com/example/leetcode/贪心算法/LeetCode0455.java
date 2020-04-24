package com.example.leetcode.贪心算法;

import java.util.Arrays;

public class LeetCode0455 {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j])
                i++;
            j++;
        }
        return i;
    }
}
