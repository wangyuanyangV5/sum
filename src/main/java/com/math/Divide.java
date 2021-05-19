package com.math;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }

        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }


        boolean low = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        dividend = dividend > 0 ? -dividend : dividend;

        divisor = divisor > 0 ? -divisor : divisor;



        if(divisor < dividend){
            return 0;
        }

        int tmp = dividend;
        int result = 0;
        while (tmp <= divisor){
            tmp -= divisor;
            result++;
        }

        if(low){
            return - result;
        }
        return result;
    }

    public static int divide2(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;

        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);

        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp) {
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            result+=c;
        }
        return k?result:-result;
    }

    public static int divide1(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }

        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        long dividend1 = dividend;
        long divisor1 = divisor;

        boolean low = (dividend1 > 0 && divisor1 < 0) || (dividend1 < 0 && divisor1 > 0);
        dividend1 = dividend1 < 0 ? -dividend1 : dividend1;

        divisor1 = divisor1 < 0 ? -divisor1 : divisor1;



        if(divisor1 > dividend1){
            return 0;
        }

        long tmp = dividend1;
        int result = 0;
        while (tmp >= divisor1){
            tmp -= divisor1;
            result++;
        }

        if(low){
            return - result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.print(divide(10,3));
//        System.out.println("");
//        System.out.println(Integer.MIN_VALUE == -2147483648);
    }
}
