package com.math;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int best = 10000000;


        for( int i = 0;i < n ;i++){
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n -1;

            while ( j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(target == sum){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }

                if(sum > target){
                    int tmpk = k - 1;
                    while (j < tmpk && nums[tmpk] == nums[k]){
                        tmpk -- ;
                    }
                    k = tmpk;
                }else {
                   int tmpj = j + 1;
                   while (tmpj < k && nums[tmpj] == nums[k]){
                       tmpj ++;
                   }
                   j = tmpj;
                }
            }

        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,0,1,2};
        threeSumClosest(nums,1);
    }
}
