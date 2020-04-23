package com.example.leetcode;

public class LeetCode0075 {
    /**
     * 三指针交换，精髓在++ ,--
     */


    public static void main(String [] args) {
        int [] nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int p1 = -1, cur = 0, p2 = nums.length;
        while (cur < p2) {
            if (nums[cur] == 0) {
                swap(nums, ++p1, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, --p2);
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
