package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0524 {

    public static void main(String [] args) {
        String a = "abpcplea";
        ArrayList<String> b = new ArrayList<>();
        b.add("a");
        b.add("b");
        b.add("c");
        b.add("d");
        System.out.println(findLongestWord(a , b));
    }

    public static String findLongestWord(String s, List<String> d) {
        String matchString = "";
        for (int i = 0; i < d.size(); i++) {
            if (isVerify(s, d.get(i))) {
                if (matchString.length() < d.get(i).length() || (matchString.length() == d.get(i).length() && matchString.compareTo(d.get(i)) > 0)) {
                    matchString = d.get(i);
                }
            }
        }
        return matchString;
    }

    public static boolean isVerify(String origin, String s) {
        int p1 = 0, p2 = 0;
        while (p1 < origin.length() && p2 < s.length()) {
            if (origin.charAt(p1) == s.charAt(p2)) {
                p2++;
            }
            p1++;
            if (p2 == s.length())
                return true;
        }
        return false;
    }
}


