package com.example.leetcode.贪心算法;

public class LeetCode0605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowCount = 0, index = 1;
        for (int i = 0;i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (++index == 3 || ( i == flowerbed.length - 1 && index == 2)) {
                    index = 1;
                    flowCount++;
                }
            } else {
                index = 0;
            }
        }
        return flowCount >= n;
    }
}
