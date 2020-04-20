package com.example.chapter1.排序;

import java.util.Random;

public class QuickSelectSort {
    public static void main(String[] args) {
        //快排序
        int[] array = new int[]{8, 9, 1, 7, 3, 2, 5, 6, 13, 15};
//        int[] array = new int[]{8, 9, 1, 7, 3};
//        System.out.println(quickSelectSort(array, 0, array.length - 1, 2));
        System.out.println(findKthLargest2(array, 2));


    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int e = partition(nums, i, j);
            if (e == k) {
                break;
            } else if (e < k) {
                i = (int) (e + Math.random() * (k-e+ 1));
            } else {
                j = (int) (k + Math.random() * (e-k + 1));
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int low, int high) {
        int i = low, j = high, tmp = a[low];
        while (i < j) {
            while (a[j] >= tmp && i < j) {
                j--;
            }
            while (a[i] <= tmp && i < j) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, low, i);
        return i;
    }
}
