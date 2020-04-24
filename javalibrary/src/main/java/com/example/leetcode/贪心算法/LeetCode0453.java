package com.example.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠区间问题
 */
public class LeetCode0453 {


    public static void main(String [] args) {
        System.out.println();
    }
    class MyCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new MyCompare());
        int result = 1;
        int left = intervals[0][1];
        for (int [] item : intervals) {
            // 这里第一次比较的时候已经自己和自己比较一定不成立。
            if (item[0] >= left) {
                result++;
                left = item[1];
            }
        }
        //计算的是不可以共存的结果，因此需要用开始的长度减一下。
        return intervals.length - result;
    }

}
