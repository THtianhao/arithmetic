package com.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode0347 {
    public static void main(String [] args) {
        int []nums = new int[]{1,1,1,2,2,3};
        topKFrequent(nums,2);
        System.out.println();

    }
    public static int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1 );
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer integer, Integer t1) {
                return map.get(integer) - map.get(t1);
            }
        });
        for (int b : map.keySet()) {
            queue.add(b);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        int [] result = new int[queue.size()];
        int size = queue.size();
        for(int i  = 0; i < size; i++) {
            result[i] =  queue.remove();
        }
        return result;
    }
}
