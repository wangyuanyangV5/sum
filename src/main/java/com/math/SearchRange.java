package com.math;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target){
                int left = mid;
                int right= mid;
                for(int i = mid;i >= 0;i--){
                    if(nums[i]==target){
                        left = i;
                        continue;
                    }
                    break;
                }
                for(int i = mid;i< nums.length;i++){
                    if(nums[i]==target){
                        right = i;
                        continue;
                    }
                    break;
                }
                return new int[]{left,right};
            }
            if(nums[mid] > target){
                r = mid -1;
                continue;
            }
            if(nums[mid] < target){
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] result= searchRange(new int[]{1},1);
        System.out.println("["+ result[0]+","+result[1]+"]");
    }
}
