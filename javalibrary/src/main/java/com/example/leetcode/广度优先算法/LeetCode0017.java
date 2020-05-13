package com.example.leetcode.广度优先算法;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0017 {
    static String a = "asdasd";

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    static List<String> res = new ArrayList<String>();

    static String [][] key = new String [][]{
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public static List<String> letterCombinations(String digits) {
        backTrack(digits, "");
        return res;
    }

    private static void backTrack(String digits, String nextString) {
        if (digits.length() == 0){
            res.add(nextString);
            return;
        }
        String[] item = key[Integer.valueOf(digits.substring(0, 1))];
        for (int i = 0; i < item.length; i++) {
            backTrack(digits.substring(1), item[i] + nextString);
        }
    }
}
