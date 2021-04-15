package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        Map<Integer, List<Character>> stringS = new HashMap<>();
        for(int i =0;i < numRows;i++){
            stringS.put(i,new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        Integer index = 0;
        boolean down =true;
        int row = numRows -1;
        for(char c : chars){

            stringS.get(index).add(c);


            if(down){
                if(index >= row){
                    down = false;
                    index -=1;
                }else {
                    index++;
                }
            }else {
                if(index == 0){
                    down = true;
                    index +=1;
                }else {
                    index--;
                }
            }
        }
        String result ="";
        for(int i =0;i < numRows;i++){
            for(Character s1 : stringS.get(i)){
                result += s1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",4));
        System.out.println(convert("AB",1));
    }
}
