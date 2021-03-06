package com.example.leetcode;

import java.util.Arrays;
/*
快排思想，找到一个基准（一般在数组的最左边），小于基准的放到基准左边，大于基准的放到基准右边
查找：先找两个数，从右边往左边找找到一个小于基准的(每次必须是右边先走)
                再从左边往右边找找到一个大于基准的。
移动：交换两个数字的位置。
结束：当左右相等的时候那么一次排序就结束了。
移动：结束后最后的数字要和基准换位置。
递归：再以基准一分为二左右递归。
所有结束：传入的参数相等那么就结束
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 2, 3, 4, 6, 2, 5, 6, 13, 15};
        int left = 0, right = array.length - 1;
        quickSort(array, left, right);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] arrya, int left, int right) {
        if (left > right) {
            return;
        }
        int tmp = arrya[left];
        int low = left;
        int high = right;
        while (left < right) {
            while (tmp <= arrya[right] && left < right) {
                right--;
            }
            while (tmp >= arrya[left] && left < right) {
                left++;
            }
            if (left < right) {
                swap(arrya, left, right);
            }
        }
        swap(arrya, low, left);
        quickSort(arrya, low, left - 1);
        quickSort(arrya, left + 1, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
