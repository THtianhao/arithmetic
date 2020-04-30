package com.example.leetcode.分治;


import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class LeetCode0095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return genTree(1, n);
    }

    public List<TreeNode> genTree(int start, int end) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genTree(start, i - 1);
            List<TreeNode> right = genTree(i + 1, end);
            for (TreeNode j : left) {
                for (TreeNode k : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = j;
                    node.right = k;
                    nodes.add(node);
                }
            }
        }
        if (nodes.size() == 0) {
            nodes.add(new TreeNode(start));
        }
        return nodes;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
