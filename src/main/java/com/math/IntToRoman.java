package com.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 * 示例1:
 * 输入:3
 * 输出: "III"
 *
 * 示例2:
 * 输入:4
 * 输出: "IV"
 *
 * 示例3:
 * 输入:9
 * 输出: "IX"

 * 示例4:
 * 输入:58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例5:
 * 输入:1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        StringBuilder stringBuilder = new StringBuilder();

        int addLength = num/1000;
        while (addLength > 0){
            stringBuilder.append(map.get(1000));
            addLength --;
        }
        num = num % 1000;
        if(num >= 900){
            num -= 900;
            stringBuilder.append(map.get(900));
        }
        if(num >= 500){
            num -= 500;
            stringBuilder.append(map.get(500));
        }
        if(num >= 400){
            num -= 400;
            stringBuilder.append(map.get(400));
        }

         addLength = num/100;
        while (addLength > 0){
            stringBuilder.append(map.get(100));
            addLength --;
        }

        num = num % 100;

        if(num >= 90){
            num -= 90;
            stringBuilder.append(map.get(90));
        }
        if(num >= 50){
            num -= 50;
            stringBuilder.append(map.get(50));
        }
        if(num >= 40){
            num -= 40;
            stringBuilder.append(map.get(40));
        }

        addLength = num/10;
        while (addLength > 0){
            stringBuilder.append(map.get(10));
            addLength --;
        }

        num = num % 10;

        if(num >= 9){
            num -= 9;
            stringBuilder.append(map.get(9));
        }
        if(num >= 5){
            num -= 5;
            stringBuilder.append(map.get(5));
        }
        if(num >= 4){
            num -= 4;
            stringBuilder.append(map.get(4));
        }

        addLength = num;
        while (addLength > 0){
            stringBuilder.append(map.get(1));
            addLength --;
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
