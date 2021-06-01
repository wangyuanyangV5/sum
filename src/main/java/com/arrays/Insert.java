package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 *
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 *
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 *
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 105
 *
 * 链接：https://leetcode-cn.com/problems/insert-interval
 */
public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] matrix = null;

        int[][] result = null;
//        matrix = new int[][]{
//                new int[]{1,3},
//                new int[]{6,9}
//        };
//        result = insert.insert(matrix,new int[]{2,5});
//        matrix = new int[][]{
//                new int[]{1,2},
//                new int[]{3,5},
//                new int[]{6,7},
//                new int[]{8,10},
//                new int[]{12,16},
//        };
//        result = insert.insert(matrix,new int[]{4,8});
        matrix = new int[][]{
                new int[]{1,5},
        };
        result = insert.insert(matrix,new int[]{5,7});
        System.out.print("[");
        for(int i =0;i < result.length;i++){
            System.out.print("[");
            System.out.print(result[i][0]);
            System.out.print(",");
            System.out.print(result[i][1]);
            System.out.print("]");
            System.out.print(",");
        }
        System.out.print("]");
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0){
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }

        int end = newInterval[1];
        if(end < intervals[0][0]){
            result.add(newInterval);
            result.addAll(Arrays.asList(intervals));
            return result.toArray(new int[result.size()][]);
        }

        if(end == intervals[0][0]){
            result.add(new int[]{newInterval[0],intervals[0][1]});
            for(int i = 1;i < intervals.length;i++){
                result.add(intervals[i]);
            }
            return result.toArray(new int[result.size()][]);
        }

        int start = newInterval[0];
        int resultFirst = -1;
        int resultSecond = -1;
        for(int[] ints : intervals){
            int tmpStart = ints[0];
            int tmpEnd = ints[1];
            if(resultSecond == -1 && end <=tmpEnd){
                if(end < tmpStart){
                    resultSecond = end;
                }else {
                    resultSecond = tmpEnd;
                }
                if(resultFirst != -1 && resultSecond != -1){
                    result.add(new int[]{resultFirst,resultSecond});
                }
            }

            if(tmpStart > end || tmpEnd < start){
                if(resultFirst == -1 && end < tmpStart){
                    result.add(newInterval);
                    resultFirst = tmpStart;
                    resultSecond = tmpEnd;
                }
                result.add(ints);

            }
            if(start < tmpStart && tmpEnd < end){
                continue;
            }

            if(resultFirst ==  -1 && start <= tmpEnd){
                if(start < tmpStart){
                    resultFirst = start;
                }else {
                    resultFirst = tmpStart;
                }
                if(resultFirst != -1 && resultSecond != -1){
                    result.add(new int[]{resultFirst,resultSecond});
                }
            }



        }

        if(resultFirst == -1 && resultSecond == -1){
            result.add(newInterval);
        }

        if(resultFirst != -1 && resultSecond == -1){
            result.add(new int[]{resultFirst,end});
        }

        return  result.toArray(new int[result.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }


}
