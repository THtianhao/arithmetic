package com.example.leetcode.二分查找;

public class LeetCode0034 {
    public static void main(String[] args) {
        int[] a = new int[]{1};

        System.out.println(searchRange(a, 1));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int ml = -1, mr = -1;
        while (left <= right) {
            int m = (left + right) >>> 1;
            if (nums[m] > target) {
                right = m - 1;
            } else if (nums[m] < target) {
                left = m + 1;
            } else {
                ml = mr = m;
                while(ml != 0 && nums[ml - 1] == target){
                    ml--;
                }
                result[0] = ml;
                while(mr != nums.length - 1 && nums[mr + 1] == target){
                    mr++;
                }
                result[1] = nums[--mr];
                return result;
            }
        }
        return result;
    }
}
