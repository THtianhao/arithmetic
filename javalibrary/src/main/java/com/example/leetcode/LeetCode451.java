package com.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode451 {
    public static void main(String [] args) {
        frequencySort2("tee");
        System.out.println();
    }

    /**
     * 这种方法错误，因为map放入的顺序是错误的，如果数字一样的话就坏了如：aaabbb
     * @param s
     * @return
     */
    public static  String frequencySort1(String s) {
        char [] array = new char[256];
        final HashMap<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            array[a]++;
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return map.get(c2) - map.get(c1);
            }
        });

        for (char a : array) {
            queue.add(a);
        }

        int size = queue.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static String frequencySort2(String s) {
        final char [] array = new char[256];
        final HashMap<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            array[a]++;
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return array[c2] - array[c1];
            }
        });
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        String a = Arrays.toString(queue.toArray(new Character[]{}));


        int size = queue.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}

