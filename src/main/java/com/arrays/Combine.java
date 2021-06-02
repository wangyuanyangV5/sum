package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *]
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        if(n == k){
            List<Integer> list = new ArrayList<>(n);
            for(int i =1;i <= n;i++){
                list.add(i);
            }
            return Collections.singletonList(list);
        }


        return null;
    }
}
