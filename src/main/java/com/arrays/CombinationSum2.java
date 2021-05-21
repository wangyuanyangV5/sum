package com.arrays;

import java.util.*;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例2:
 *
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashMap<Integer,Integer> map =new HashMap<>(candidates.length);
        for(int i =0;i<candidates.length;i++){
             int now = candidates[i];
             if(map.containsKey(now)){
                 map.put(now,map.get(now)+ 1);
             }else {
                 map.put(now,1);
             }
        }

        return fundSum(map,target,new ArrayList<>());
    }

    public static  List<List<Integer>> fundSum( HashMap<Integer,Integer> map,int target,List<List<Integer>> result){
        if(target < 1){
            return result;
        }
        List<String> results = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int now = entry.getKey();
            int count = entry.getValue();

            if(count < 1){
                continue;
            }
            HashMap<Integer,Integer> tmpMap = new HashMap<>(map);
            if(count == 1){
                tmpMap.remove(now);
            }else {
                tmpMap.put(now,tmpMap.get(now) -1);
            }
            List<List<Integer>>  tmpList = fundSum(tmpMap,target - now,new ArrayList<>());


            for(List<Integer> list : tmpList){
                list.add(now);
                list.sort(Integer::compareTo);
                if(!results.contains(list.toString())){
                    result.add(list);
                    results.add(list.toString());
                }
            }

            if(now == target){
                List<Integer> list = new ArrayList<>();
                list.add(now);
                result.add(list);
            }

        }
        return result;
    }



    public static void main(String[] args) {
//        List<List<Integer>> result = combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        List<List<Integer>> result = combinationSum2(new int[]{2,5,2,1,2},5);
        System.out.println(result);
    }

}
