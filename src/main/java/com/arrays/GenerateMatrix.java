package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        generateMatrix.generateMatrix(7);
    }
    public int[][] generateMatrix(int n) {
        List<int[]> list = new ArrayList<>();
        for(int i =0;i < n;i ++){
            int[] tmp = new int[n];
            list.add(tmp);
        }
        int now = 0;
        for(int i =0;i < n;i++){
            int right = n - i  ;
            int low =  n - i  -1;
            int left = n - i - 1;
            int high = n - i   - 2;


            for(int j = i;j <right;j++){
                int[] tmp = list.get(i);
                tmp[j] = ++now;
            }
            for(int h = i + 1;h <low;h++){
                int[] tmp = list.get(h);
                tmp[n -1 - i]  = ++ now;
            }

            if(left > i){
                for(int l = left;l >=i;l--){
                    int[] tmp = list.get(n - i  -1);
                    tmp[l] = ++now;
                }
            }

            for(int h = high;h > i;h--){
                int[] tmp = list.get(h);
                tmp[i] = ++ now;
            }
        }
        for(int[] ints : list){
            for(int i = 0;i < ints.length;i++){
                System.out.print(ints[i] + " ");
            }
            System.out.println("");
        }
        return list.toArray(new int[n][n]);
    }
}
