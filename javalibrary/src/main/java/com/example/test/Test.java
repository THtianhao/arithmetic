package com.example.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

public class Test {
    public static void main(String [] args) {
        String s = "abbab";

//        System.out.println(validPalindrome(s));
        int [] arr = new int[]{4, 5, 6, 0, 0, 0};
        int m = 3, p = 0;

        int [] arr2 = new int[]{1, 2, 3};
//        System.arraycopy(arr, p, arr, p + 1, m - p);
        System.out.println(Arrays.toString(arr));
        merge(arr,3,arr2,3);

    }
    public static boolean validPalindrome(String s) {
        char [] arr = s.toCharArray();
        boolean deleteChar = false;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if(arr[i] != arr[j]){
                if (arr[i+1] == arr[j] && !deleteChar){
                    i++;
                    deleteChar = true;
                } else if (arr[i] == arr[j-1] && !deleteChar) {
                    j--;
                    deleteChar = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int []nums1_copy = new int[m];
        System.arraycopy(nums1, 0 ,nums1_copy ,0 , m);
        int p = 0, q = 0, i = 0;
        while (p < m && q < n) {
            nums1[i++] = nums1_copy[p] > nums2[q] ? nums2[q++] : nums1_copy[p++];
        }

        if (p < m){
            System.arraycopy(nums1_copy , p , nums1 , p + q, m - p);
        }
        if (q < n){
            System.arraycopy(nums2, q, nums1,p + q, n - q);
        }
    }

}
