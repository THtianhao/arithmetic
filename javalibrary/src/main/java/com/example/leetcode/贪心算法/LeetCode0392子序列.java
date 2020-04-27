package com.example.leetcode.贪心算法;

public class LeetCode0392子序列 {
    public static void main(String [] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static  boolean isSubsequence(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            int index = i, count = 0;
            while(index < t.length()) {
                if (t.charAt(index) == s.charAt(count)){
                    count++;
                    if (count == s.length()) {
                        return true;
                    }
                }
                index++;
            }
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        int index = -1;
        for (char a :s.toCharArray()) {
            index = t.indexOf(a, index++);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}
