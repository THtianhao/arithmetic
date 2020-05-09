package com.example.leetcode.广度优先算法;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class LeetCode0127 {

    public static void main(String[] args) {
        List<String> ex = new ArrayList<>();
        ex.add("hot");
        ex.add("dot");
        ex.add("dog");
        ex.add("lot");
        ex.add("log");
        System.out.println(ladderLength2("hit", "cog", ex));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }


    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        List<String> visit = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int deep = 1;
        int current = 0;
        int len = q.size();
        while (!q.isEmpty()) {
            String b = q.poll();
            if (b.equals(endWord)) {
                return deep;
            }
            for (String c : wordList) {
                if (checkdiff(b, c) == 1) {
                    q.add(c);
                }
            }
            if (!visit.contains(b)) {
                visit.add(b);
                wordList.remove(b);
            }
            current++;
            if (current == len) {
                deep++;
                current = 0;
                len = q.size();
            }
        }
        return 0;
    }

    public static int checkdiff(String a, String b) {
        int diff = 0;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        for (int i = 0; i < aArray.length; i++) {
            if (aArray[i] != bArray[i]) {
                diff++;
            }
        }
        return diff;
    }
}


