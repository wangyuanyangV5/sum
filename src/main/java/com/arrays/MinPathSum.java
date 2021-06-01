package com.arrays;

/**
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int[][] grid = null;
        int result = 0;
        grid = new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1},
        };
        System.out.println(minPathSum.minPathSum(grid));
        grid = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
        };
        System.out.println(minPathSum.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] results = new int[m][n];

        for(int i = 0;i < n;i++){
            if(i == 0){
                results[0][i] = grid[0][0];
            }else {
                results[0][i] = results[0][i -1] + grid[0][i];
            }
        }

        for(int i = 0;i < m;i++){
            if(i == 0){
                results[i][0] = grid[0][0];
            }else {
                results[i][0] = results[i -1][0] + grid[i][0];
            }
        }

        for (int i =1;i < m;i++){
            for (int j = 1;j<n;j++){
                int min = Math.min(results[i][j - 1], results[i - 1][j]);
                results[i][j] = min + grid[i][j];
            }
        }

        return results[m -1][n -1];
    }
}
