package com.example.leetcode.广度优先算法;

import java.util.LinkedList;

/**
 * 广度优先算法是一层一层遍历的，每一层要遍历所有的节点，解决找到路径问题和，最小路径问题
 * 首先需要判断起点和终点，
 * 其次要找到路径，上下左右走的路径
 * 找到最后的点就返回
 * 其次一般是用队列来进行的将所有的遍历到的内容都放入到节点当中。
 * 关于深度的计算可以用两个变量或者用两个数字，一个是节点数量，另外一个是存储一个一起维护的数值来计算。
 */
public class Leetcode1091 {
    public static void main(String [] args) {
        int [][] sss = new int[][]{{0}};
        System.out.println(shortestPathBinaryMatrix(sss));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid[0].length - 1][grid.length - 1] == 1) return -1;
        grid[0][0] = 1;
        int deep = 1;
        LinkedList<int []> lists = new LinkedList<>();
        lists.add(new int[] {0, 0});
        int len = lists.size();
        int a = 0;
        int [][] plus = new int[][] {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        while (!lists.isEmpty()) {
            int [] item  = lists.poll();
            for (int [] k : plus) {
                int x = item[0] + k[0];
                int y = item[1] + k[1];
                if (x == grid[0].length - 1 && y == grid.length - 1) {
                    return deep;
                }
                if (x >=0 && y >= 0 && x < grid[0].length && y < grid.length && grid[x][y] == 0) {
                    grid[x][y] = 1;
                    lists.add(new int[] {x, y});
                }
            }
            a++;
            if (a == len) {
                a = 0;
                deep++;
                len = lists.size();
            }
        }
        return -1;
    }
}
