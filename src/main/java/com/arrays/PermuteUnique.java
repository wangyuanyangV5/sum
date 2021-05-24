package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> tmp = Collections.singletonList(nums[0]);
            resultList.add(tmp);
            return resultList;
        }

        return getList(nums,new ArrayList<>());
    }

    private static List<List<Integer>> getList(int[] nums,List<Integer> useIndexs){
        if(nums.length == useIndexs.size()){
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        List<String> useString = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(!useIndexs.contains(i)){
                List<Integer> tmpUseList = new ArrayList<>(useIndexs);
                tmpUseList.add(i);
                List<List<Integer>> tmpResults = getList(nums,tmpUseList);
                if(tmpResults == null){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    String stringResult = tmpList.toString();
                    if(!useString.contains(stringResult)){
                        useString.add(tmpList.toString());
                        results.add(tmpList);
                    }
                }else {
                    for(List<Integer> list1 : tmpResults){
                        list1.add(nums[i]);
                        String stringResult = list1.toString();
                        if(!useString.contains(stringResult)){
                            useString.add(stringResult);
                            results.add(list1);
                        }
                    }
                }
            }
        }

        return results;
    }
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{1,1,2}));
        System.out.println(permuteUnique.permuteUnique(new int[]{1,2,3}));
    }
}
