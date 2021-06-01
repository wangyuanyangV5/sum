package com.string;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 *
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 * 提示：
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *链接：https://leetcode-cn.com/problems/rotate-image
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int high = 0;
        for(int left = 0;left < length;left++){
            int right = length -1 - left;
            if(right <= left){
                break;
            }
            doRotate(matrix,left,right,high);
            high++;
        }
    }

    private void doRotate(int[][] matrix,int i,int j,int h){
        int length = j - i;
        for(int left=i;left< j;left++){
            int tmp1 = matrix[h + left -i][j];
            matrix[h + left -i][j] = matrix[h][left];

            int tmp2 = matrix[h + length][j +i - left];
            matrix[h + length][j +i - left] = tmp1;


            tmp1 = matrix[h + length - left + i ][i];
            matrix[h + length - left + i ][i] = tmp2;

            matrix[h][left] = tmp1;
        }
    }

    private void doRotate1(int[][] matrix,int i,int j,int h){
        int length = j - i;
        for(int left=i;left< j;left++){
            int tmp3 = matrix[h][left];
            matrix[h][left] = matrix[h + length - left + i ][i];

            matrix[h + length - left + i ][i] = matrix[h + length][j +i - left];

            matrix[h + length][j +i - left] = matrix[h + left -i][j];

            matrix[h + left -i][j] = tmp3;
        }
    }



    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }


    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = null;
//        matrix = new int[][]{
//          new int[]{1}
//        };
//        matrix = new int[][]{
//          new int[]{1,2},
//          new int[]{3,4}
//        };
//        matrix = new int[][]{
//                new int[]{1,2,3},
//                new int[]{4,5,6},
//                new int[]{7,8,9}
//        };
        matrix = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16},
        };
        rotate.rotate(matrix);
        for(int i = 0;i< matrix.length;i++){
            System.out.print("[");
            for(int j = 0;j< matrix.length;j++){
              System.out.print(matrix[i][j]);
                System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
