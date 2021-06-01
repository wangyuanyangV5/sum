package com.arrays;

/**
 *一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 *
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 *
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
        System.out.println(uniquePaths.uniquePaths(3,2));
        System.out.println(uniquePaths.uniquePaths(7,3));
        System.out.println(uniquePaths.uniquePaths(3,3));
        long time = System.currentTimeMillis();
        System.out.println(uniquePaths.uniquePaths(51,9));
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        System.out.println(uniquePaths.uniquePaths1(51,9));
        System.out.println(System.currentTimeMillis() - time);
    }
    public int uniquePaths(int m, int n) {
        return sumResult(0,0,m,n);
    }

    private int sumResult(int i,int j,int m, int n){
        if(i  == m -1  || j == n - 1){
            return 1;
        }
        return sumResult(i + 1,j,m,n ) + sumResult(i ,j+1,m,n);

    }

    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


}
