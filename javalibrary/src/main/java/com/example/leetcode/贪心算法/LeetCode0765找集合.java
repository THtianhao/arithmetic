package com.example.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0765找集合 {
    public static void main(String [] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(3 >> 1);
    }

    public static List<Integer> partitionLabels(String s) {
        int [] last = new int [26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int j = 0; int index = 0;
        for (int i = 0; i < s.length(); i++) {
            //在过程中遇到有比第一次出现大的，会更新j，比如e；
            j = Math.max(last[s.charAt(i) - 'a'], j);
            if (i == j) {
                result.add(i - index + 1);
                index = i + 1;
            }
        }
        return result;
    }
}
