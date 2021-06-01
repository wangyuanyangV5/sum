package com.math;

/**
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *由于返回类型是整数，小数部分将被舍去。
 *）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(3));
        System.out.println(mySqrt.mySqrt(4));
        System.out.println(mySqrt.mySqrt(7));
        System.out.println(mySqrt.mySqrt(8));
        System.out.println(mySqrt.mySqrt(9));
    }
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
