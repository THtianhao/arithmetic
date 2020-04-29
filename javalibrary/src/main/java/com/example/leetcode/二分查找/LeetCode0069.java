package com.example.leetcode.二分查找;

public class LeetCode0069 {

    public static void main(String[] args) {
        int a  = 2126753390>>>1;
        System.out.println(mySqrt2(8));
    }

    public static int mySqrt(int x) {
        return (int) binarySearch(x, 0, x);
    }

    public static long binarySearch(long x, long left, long right) {
        long mid = (left + right) >> 1;
        if (mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)) return mid;
        if (mid * mid > x) {
            return binarySearch(x, left, mid - 1);
        } else {
            return binarySearch(x, mid + 1, right);
        }
    }

    public static int mySqrt2(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }

        return right;
    }
}
