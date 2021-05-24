package com.arrays;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 链接：https://leetcode-cn.com/problems/permutations
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> tmp = Collections.singletonList(nums[0]);
            resultList.add(tmp);
            return resultList;
        }

        return getList(nums,new ArrayList<>());
    }

    private static List<List<Integer>> getList(int[] nums,List<Integer> useList){
        if(nums.length == useList.size()){
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        for(Integer index : nums){
            if(!useList.contains(index)){
                List<Integer> tmpUseList = new ArrayList<>(useList);
                tmpUseList.add(index);
                List<List<Integer>> tmpResults = getList(nums,tmpUseList);
                if(tmpResults == null){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(index);
                    results.add(tmpList);
                }else {
                    for(List<Integer> list1 : tmpResults){
                        list1.add(index);
                        results.add(list1);
                    }
                }
            }
        }

        return results;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute1(new int[]{1,2,3}));
        System.out.println(permute1(new int[]{0,1}));
    }
}
