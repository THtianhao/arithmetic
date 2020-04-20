package com.example.chapter1.排序;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
快排思想，找到一个基准（一般在数组的最左边），小于基准的放到基准左边，大于基准的放到基准右边
查找：先找两个数，从右边往左边找找到一个小于基准的(每次必须是右边先走)
                再从左边往右边找找到一个大于基准的。
移动：交换两个数字的位置。
结束：当左右相等的时候那么一次排序就结束了。
移动：结束后最后的数字要和基准换位置。
递归：再以基准一分为二左右递归。
所有结束：传入的参数相等那么就结束
错误点：注意>=和<=
        一定要从右往左判断
 */

public class QuickSort {
    public static void main(String[] args) {
        //快排序
        int[] array = new int[]{8, 9, 1, 7, 3, 4, 6, 2, 5, 6, 13, 15};
        int left = 0, right = array.length - 1;
        quickSort(array, left, right);
        System.out.println(Arrays.toString(array));
        //小顶堆排序

//        heapSort(array,3);

    }

    /*
    快排
     */
    static void quickSort(int [] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low, j = high, temp = nums[low];
        while (i < j) {
            while (nums[j] >= temp && i < j) {
                j--;
            }
            while (nums[i] <= temp  && i < j) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, low, i);
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    static void swap(int [] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    static int heapSort(int [] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int e : nums) {
            minHeap.add(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
