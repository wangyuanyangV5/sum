package com.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        char[] firsts = num1.toCharArray();
        char[] seconds = num2.toCharArray();
        int firstLength = firsts.length;
        int secondLength = seconds.length;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,Integer> secondMap = new HashMap<>();
        for(int i=0;i < secondLength;i++){
            secondMap.put(i,Integer.parseInt(seconds[i]+""));
        }
        int addSum = 0;
        for(int i = firstLength -1;i >=0;i--){
            Integer now = Integer.parseInt(firsts[i]+"");
            int base = firstLength - i;
            for(int j = secondLength -1;j >=0;j--){
                int addIndex = secondLength - 1 -j;
                int mapKey = base + addIndex;
                Integer second = secondMap.get(j);
                Integer sum = second * now + addSum;

                if(map.containsKey(mapKey)){
                   Integer nowValue = map.get(mapKey);
                   sum += nowValue;
                }
                Integer value = sum %10;
                addSum = sum /10;
                map.put(mapKey,value);
            }
            if(addSum > 0){
                int addIndex = secondLength;
                int mapKey = base + addIndex;
                map.put(mapKey,addSum);
                addSum = addSum/10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = map.size(); i > 0;i--){
            stringBuilder.append(map.get(i));
        }
        return stringBuilder.toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("2","3"));
        System.out.println(multiply("123","456"));
    }
}
