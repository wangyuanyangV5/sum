package com.math;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 输入：
 * [5,4,7,5,3,2]
 * 输出：
 * [5,7,4,5,3,2]
 * 预期结果：
 * [5,5,2,3,4,7]
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return;
        }
        int first = 0;
        for(int i=length-1;i > 0;i--){
            if(nums[i] > nums[i -1]){
               first = i;
                break;
            }
        }

        if(first > 0){
            int target = nums[first -1];
            int result = length -1;
            for(int i = first; i < length - 1;i++){
                if(nums[i + 1] <= target){
                    result = i;
                    break;
                }
            }
            nums[first -1] = nums[result];
            nums[result] = target;
            int size = length - first;
            int[] tmps = new int[size];
            for(int i = 0;i < size;i++){
                tmps[i] = nums[length -1 -i];
            }
            for(int i = first;i < length;i++){
                nums[i] = tmps[i - first];
            }
            return;
        }

        for(int i=0;i<length/2;i++){
            int tmp = nums[i];
            nums[i]=nums[length -1 - i];
            nums[length -1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] tags = new int[]{2,3,1};
        nextPermutation(tags);
        for(int i=0;i < tags.length;i++){
            System.out.print(tags[i]);
        }
        System.out.println("");
    }
}
