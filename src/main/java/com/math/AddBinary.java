package com.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("10101","110000"));
    }
    public String addBinary(String a, String b) {
        char[] firsts = a.toCharArray();
        char[] seconds = b.toCharArray();
        char tag0 = '0';
        int add = 0;
        List<Character> list = new ArrayList<>();

        int firstLength =  firsts.length  -1;
        int secondLength = seconds.length -1 ;
        while ( firstLength  >= 0 && secondLength >=0 ){
            char tmpA = firsts[firstLength --];
            char tmpB =  seconds[secondLength --];
            int sum = add + tmpA + tmpB - tag0 - tag0;
            if(sum > 1){
                add = 1;
                if(sum == 2){
                    list.add('0');
                }else {
                    list.add('1');
                }
            }else {
                add = 0;
                if(sum == 1){
                    list.add('1');
                }else {
                    list.add('0');
                }
            }
        }
        if(firstLength >= 0){
            while (firstLength >=0){
                char tmp = firsts[firstLength --];
                if(tmp + add == '0'){
                    add = 0;
                }
                if(tmp + add == '1'){
                    add = 0;
                    tmp = '1';
                }
                if(tmp + add == '2'){
                    add = 1;
                    tmp = '0';
                }
                list.add(tmp);
            }
        }

        if(secondLength >= 0){
            while (secondLength >=0){
                char tmp = seconds[secondLength --];
                if(tmp + add == '0'){
                    add = 0;
                }
                if(tmp + add == '1'){
                    add = 0;
                    tmp = '1';
                }
                if(tmp + add == '2'){
                    add = 1;
                    tmp = '0';
                }
                list.add(tmp);
            }
        }

        if(add > 0){
            list.add('1');
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =list.size() -1;i >=0 ;i--){
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
