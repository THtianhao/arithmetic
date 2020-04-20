package com.example.chapter1.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AAA {
    public static void main(String[] args) {
        //快排序
        int[] array = new int[]{4,4,4,4,4,1,1,1,2,2,3};
//        int[] array = new int[]{8, 9, 1, 7, 3};
//        System.out.println(quickSelectSort(array, 0, array.length - 1, 2));
        System.out.println(topKFrequent(array, 2));


    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        // 记录每个元素的频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 按照 map 中元素的频率来创建数组，高频率的元素位于数组最后边
        List<Integer>[] tmp = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 定义 i 来接收每个元素的频率值
            int i = map.get(key);
            if (tmp[i] == null) {
                tmp[i] = new ArrayList();
            }
            // 将对应频率的元素放入以频率为下标的数组中
            tmp[i].add(key);
        }
        // 逆向找出前 k 高频率的元素
        for (int i = tmp.length - 1; i >= 0 && ans.size() < k; i--) {
            if (tmp[i] == null) {
                continue;
            }
            // 将当前频率下的元素放入结果集 ans 中
            ans.addAll(tmp[i]);
        }
        return ans;
    }
}
