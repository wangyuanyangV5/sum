package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]

 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int high = matrix.length;
        int right = matrix[0].length;
        int add = high /2 + high % 2;
        List<Integer> result = new ArrayList<>( high * right);
        for(int i = 0;i < add;i++){
            if(i < right){
                add(result,i,right - 1 - i,i,high - 1 - i,matrix);
            }

        }
        return result;
    }

    private void add(List<Integer> result,int left,int right,int minHight,int maxHight,int[][] matrix){
        int i = left;
        int j = right;
        int h = minHight;
        if(i > j){
            return;
        }

        while (i <= j){
            result.add(matrix[h][i++]);
        }

        while (h < maxHight){
            result.add(matrix[++h][j]);
        }
        if(maxHight == minHight){
            return;
        }
        i = right;
        while (i > left){
            result.add(matrix[maxHight][--i]);
        }
        if(left == right){
            return;
        }
        while (h > minHight + 1){
            result.add(matrix[--h][left]);
        }
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = null;
//        matrix = new int[][]{
//                new int[]{1,2,3,4},
//                new int[]{5,6,7,8},
//                new int[]{9,10,11,12},
//                new int[]{13,14,15,16},
//        };
//        matrix = new int[][]{
//                new int[]{1,2,3,4},
//                new int[]{5,6,7,8},
//                new int[]{9,10,11,12},
//        };
        matrix = new int[][]{
                new int[]{7},
                new int[]{9},
                new int[]{6},
        };
        System.out.println(spiralOrder.spiralOrder(matrix));
    }
}
