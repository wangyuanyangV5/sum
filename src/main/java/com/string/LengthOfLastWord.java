package com.string;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.print(lengthOfLastWord.lengthOfLastWord("a "));
    }
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int sum = 0;
        for(int i =length -1;i >=0;i--){
            if(s.charAt(i) == ' '){
                if(sum == 0){
                    continue;
                }else {
                    break;
                }
            }
            sum ++;
        }
        return sum;
    }
}
