package com.math;

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
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        char[] firsts = num1.toCharArray();
        char[] seconds = num2.toCharArray();
        int firstLength = firsts.length;
        int secondLength = seconds.length;
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (firstLength > 0 && secondLength > 0){
            Integer first = Integer.parseInt(firsts[firstLength -1]+"");
            Integer second = Integer.parseInt(seconds[secondLength -1]+"");
            Integer sum = first * second;
            Integer result = sum % 10 + add;
            add = sum /10;
            if(result > 10){
                result -=10;
                add+=1;
            }
            stringBuilder.append(result);
            firstLength --;
            secondLength --;
        }



        return null;
    }
}
