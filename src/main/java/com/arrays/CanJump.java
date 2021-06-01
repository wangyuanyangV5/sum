package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * 链接：https://leetcode-cn.com/problems/jump-game
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        int max = nums[0];
        for(int i = max;i > 0;i--){
            if(i >= nums.length - 1){
                return true;
            }
            List<Integer> list = new ArrayList<>();
            list.add(0);
            map.put(i,list);
        }
        for(int i=1;i < nums.length;i++){
            if(map.containsKey(i)){
                int addMax = nums[i];
                for(int j = addMax;j > 0;j--){
                    int now = i + j;
                    if(now >= nums.length - 1){
                        return true;
                    }
                    if(!map.containsKey(now)){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        map.put(now,list);
                    }
                }
            }
        }
        return false;
    }
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
        int[] nums =  new int[10001];
        for(int i = 10000; i >=0;i--){
            nums[i] = 10001 - i;
        }

        Long nowTime = System.currentTimeMillis();
        System.out.println(canJump.canJump(nums));
        Long endTime = System.currentTimeMillis();
        System.out.println("结束耗时为:"+ (endTime - nowTime));
    }
}
