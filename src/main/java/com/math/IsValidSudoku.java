package com.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'示。
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 */
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        List<Character> list = new ArrayList<>(16);
        for(int i =0;i < 9;i++){
            list.clear();
            for(int j =0;j < 9;j++){
                char tmp = board[i][j];
                if(tmp !='.'){
                    if(list.contains(tmp)){
                        return false;
                    }
                    list.add(tmp);
                }
            }
            list.clear();
            for(int j =0;j < 9;j++){
                char tmp = board[j][i];
                if(tmp !='.'){
                    if(list.contains(tmp)){
                        return false;
                    }
                    list.add(tmp);
                }
            }
        }
        int[][] mids = new int[][]{
                new int[]{1,1},new int[]{1,4},new int[]{1,7},
                new int[]{4,1},new int[]{4,4},new int[]{4,7},
                new int[]{7,1},new int[]{7,4},new int[]{7,7}
        };
        for(int i = 0;i < mids.length;i++){
            boolean result = all(board,mids[i][0],mids[i][1]);
            if(!result){
                return false;
            }
        }
        return true;
    }

    private static boolean all(char[][] board,int l,int f){
        List<Character> list = new ArrayList<>(16);
        for(int i = l -1; i < l +2;i++){
            for(int j = f - 1;j < f +2;j++){
                char tmp = board[i][j];
                if(tmp !='.'){
                    if(list.contains(tmp)){
                        return false;
                    }
                    list.add(tmp);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            new char[]{'5','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
