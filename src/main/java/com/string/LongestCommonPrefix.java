package com.string;

import java.util.*;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串'""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 ){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        String targetString = strs[0];
        String nowString = strs[1];
        String result = getSum(targetString,nowString);

        for(int i = 2;i < strs.length;i++){
            if(result.length() == 0){
                return "";
            }
            result = getSum(result,strs[i]);
        }

        return result;
    }


    private static  String getSum(String targetString,String nowString){
        int nowIndex = 0;
        while (nowIndex < nowString.length() && nowIndex < targetString.length()){

            if(!nowString.substring(nowIndex,nowIndex + 1).equals(targetString.substring(nowIndex,nowIndex + 1))){
                break;
            }
             ++nowIndex;
        }
        return targetString.substring(0,nowIndex);
    }

    public static void main(String[] args) {
        String[] strs =new String[] {"reflower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
