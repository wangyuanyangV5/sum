package com.math;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSumTXT(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,List<Integer>> num0UpMap = new HashMap<>();
        Map<Integer,List<Integer>> num0DownMap = new HashMap<>();
        List<Integer> num0s = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];

            if(num > 0){
                List<Integer> ups = num0UpMap.get(num);
                if(Objects.isNull(ups)){
                    ups = new ArrayList<>();
                    num0UpMap.put(num,ups);
                }
                ups.add(i);
                continue;
            }

            if(num < 0){
                List<Integer> downs = num0DownMap.get(-num);
                if(Objects.isNull(downs)){
                    downs = new ArrayList<>();
                    num0DownMap.put(-num,downs);
                }
                downs.add(i);
                continue;
            }

            if(num == 0){
                num0s.add(i);
                num0DownMap.put(0,new ArrayList<>());
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(Map.Entry<Integer,List<Integer>> entry : num0UpMap.entrySet()){
            List<List<Integer>> tmp = twoSum(num0DownMap,entry.getKey(),true);
            if(Objects.nonNull(tmp)){
                result.addAll(tmp);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : num0DownMap.entrySet()){
            List<List<Integer>> tmp = twoSum(num0UpMap,entry.getKey(),false);
            if(Objects.nonNull(tmp)){
                result.addAll(tmp);
            }
        }


        if(num0s.size() > 2){
            result.add(Arrays.asList(0,0,0));
        }

        return result;
    }

    private static List<List<Integer>> twoSum( Map<Integer,List<Integer>> numMap,Integer target,Boolean targetUp){
        if(Objects.isNull(numMap) || numMap.isEmpty()){
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> hasAdd = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : numMap.entrySet()){
            Integer num = entry.getKey();
            Integer other = target - num;
            if((num.equals(other) && entry.getValue().size() > 1) ||
                    (!num.equals(other) &&numMap.containsKey(other))){
                if(hasAdd.contains(num) && hasAdd.contains(other)){
                    continue;
                }
                List<Integer> tmp;
                if(targetUp){
                    tmp =Arrays.asList(-num,-other,target);
                }else {
                    tmp =Arrays.asList(num,other,-target);
                }

                result.add(tmp);
                hasAdd.add(other);
                hasAdd.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
