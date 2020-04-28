package com.example.leetcode.贪心算法;

public class LeetCode0665 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 3, 2, 4};
        System.out.println(checkPossibility(a));
    }

    public static boolean checkPossibility(int[] nums) {
        boolean isHasOccur = false;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                if (isHasOccur) {
                    return false;
                }
                isHasOccur = true;
                i++;
                if (i - 1 >= 0 &&  i + 1 < nums.length && nums[i + 1] < nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
