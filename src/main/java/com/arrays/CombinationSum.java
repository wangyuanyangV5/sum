package com.arrays;

import java.util.*;

/**
 *给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 * [3,5]
 * ]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,Integer> map = new HashMap<>(candidates.length);
        for(int i =0;i < candidates.length;i++){
            map.put(candidates[i],1);
        }

        return findSum(map,target,new ArrayList<>());
    }

    public static List<List<Integer>> findSum(Map<Integer,Integer> map, int target,List<List<Integer>> result ){
        if(target<= 0){
            return result;
        }
        List<String> results = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer now = entry.getKey();
            List<List<Integer>> tmpResult = new ArrayList<>();
            List<List<Integer>> tmpResults = findSum(map,target - now,tmpResult);

            for(List<Integer> list : tmpResults){
                list.add(now);
                list.sort(Integer::compareTo);
                if(!results.contains(list.toString())){
                    result.add(list);
                    results.add(list.toString());
                }
            }

            if(now.equals(target)){
                List<Integer> list = new ArrayList<>();
                list.add(now);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{2,3,6,7},7);
//        List<List<Integer>> result = combinationSum(new int[]{2,3,5},8);
        System.out.println(result);
    }
}
