package com.math;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(1));
        System.out.println(climbStairs.climbStairs(2));
        System.out.println(climbStairs.climbStairs(3));
        System.out.println(climbStairs.climbStairs(4));
    }
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] results = new int[n];
        results[0] = 1;
        results[1] = 1;
        for(int i = 0;i < n;i++){
            if(i + 1 < n){
               results[i + 1] += results[i];
            }
            if(i + 2 < n){
                results[i +2] += results[i];
            }
        }
        return results[n -1];
    }
}
