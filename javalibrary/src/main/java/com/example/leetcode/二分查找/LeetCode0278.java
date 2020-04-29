package com.example.leetcode.二分查找;

public class LeetCode0278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int m = (left + right) >> 1;
            if (isBadVersion(m)) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }


    public static boolean isBadVersion(int a) {
        if (a > 1702766719) return true;
        return false;
    }
}
