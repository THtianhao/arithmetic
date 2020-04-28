package com.example.leetcode.二分查找;

public class LeetCode0744 {
    //模运算的运用
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if (getCharInt(target) >= getCharInt(letters[letters.length - 1])) {
            return letters[0];
        }
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int m = (left + right) >> 1;
            if (getCharInt(letters[m]) <= getCharInt(target)) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return letters[right];
    }

    public static int getCharInt(char a) {
        return a - 'a';

    }

    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int m = (left + right) >> 1;
            if (letters[m] <= target) left = m + 1;
            else right = m;
        }
        return letters[target % letters.length];
    }
}