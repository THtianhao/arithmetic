package com.example.leetcode.分治;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0241 {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        char operation;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                operation = input.charAt(i);
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int j : left) {
                    for (int k : right) {
                        switch (operation) {
                            case '+':
                                result.add(j + k);
                                break;
                            case '-':
                                result.add(j - k);
                                break;
                            case '*':
                                result.add(j * k);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0){
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
