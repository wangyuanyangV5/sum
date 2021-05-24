package com.arrays;

/**[10,9,8,7,6,5,4,3,2,1,1,0]
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *  从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * 输入: [2,3,0,1,4]
 * 输出: 2
 * 提示:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 */
public class Jump {
    public static int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return  0;
        }
        if( nums[0] >= nums.length -1){
            return 1;
        }
        int nowIndex = 0;
        int count = 0;
        int maxCount = 0;
        while (nowIndex  < nums.length -1){
            if( maxCount >= nums.length -1){
                return count +1;
            }
            int maxIndex = nums[nowIndex] + nowIndex;

            int resultIndex = nowIndex + 1;
            for(int i=nowIndex + 1;i < nums.length && i <= maxIndex;i++){
                if(nums[i] + i >= maxCount){
                    maxCount = nums[i] + i;
                    resultIndex = i;
                }
            }
            count++;
            nowIndex = resultIndex;
        }
        return count;
    }
    public int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {

        System.out.println(jump(new int[]{1,2}));
        System.out.println(jump(new int[]{3,2,1}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{1,2,0,1}));
        System.out.println(jump(new int[]{1,2,1,1,1}));
        System.out.println(jump(new int[]{2,1,1,1,1}));
        System.out.println(jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
        System.out.println(jump(new int[]{4,1,1,3,1,1,1}));
    }
}
