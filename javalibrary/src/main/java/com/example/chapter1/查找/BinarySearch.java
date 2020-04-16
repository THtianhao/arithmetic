package com.example.chapter1.查找;

import java.util.HashMap;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 11;
//        int position = binarySearch1(arr, key);
//        int position = binarySearch2(arr, 0, arr.length - 1, key);
        boolean position = judgeSquareSum(1000000000);
        System.out.println(position);
    }

    /*
    二分查找的递归算法
     */
    private static int binarySearch2(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int middle = (low + high) / 2;
            if (key == arr[middle]) {
                return middle;
            } else if (key < arr[middle]) {
                return binarySearch2(arr, low, middle - 1, key);
            } else if (key >= arr[middle]) {
                return binarySearch2(arr, middle + 1, high, key);
            }
        }
        return 0;
    }

    /*
    普通算法
     */
    private static int binarySearch1(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == arr[middle]) {
                return middle;
            }
            if (key < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static boolean judgeSquareSum(int c) {
        for(long a = 0;  a * a <= c; a++){
            long b = c - (a * a);
            if(binarySearch(0, b, b)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(long low, long high, long key){
        if (low > high) return false;
        long middle = (low + high) / 2;
        if (key == middle * middle) return true;
        if (middle * middle > key)
            return binarySearch(low, middle - 1, key);
        return binarySearch(middle + 1, high, key);
    }


}

