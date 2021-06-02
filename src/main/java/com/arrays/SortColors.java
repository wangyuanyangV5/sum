package com.arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 链接：https://leetcode-cn.com/problems/sort-colors
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = null;
        nums = new int[]{2,0,2,1,1,0};
        sortColors.maoPao(nums);
        sortColors.print(nums);

        nums = new int[]{2,0,2,1,1,0};
        System.out.println("");
        sortColors.quitSort(nums,0,nums.length -1);
        sortColors.print(nums);
    }

    public void sortColors(int[] nums) {

    }

    private void quitSort(int[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int flag = nums[left];
        int l = left + 1;
        int r = right;
        while (l < r){
            while (l < r && nums[r] >= flag){
                r --;
            }

            while (l < r && nums[l] <= nums[flag]){
                l++;
            }

            swap(nums,l,r);
        }
        nums[left] = nums[r];
        nums[r] = flag;
        print(nums);

        quitSort(nums,left,r -1);
        quitSort(nums,r + 1,right);

    }
    public  void quickSort(int[] arr,int low,int high) {
        int p,i,j,temp;

        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }
            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）
            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        print(arr);
        quickSort(arr,low,j-1);  //对左边快排
        quickSort(arr,j+1,high); //对右边快排

    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void maoPao(int[] nums){
        for(int i = 0;i < nums.length;i++){
            int max = 0;
            for(int j = 0 ;j < nums.length - i;j++){
                if(nums[max] < nums[j]){
                    max = j;
                }
            }
            int tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[max];
            nums[max] = tmp;
        }
    }

    private void print(int[] nums){
        for(int i =0;i < nums.length;i++){
            System.out.print(nums[i]);
            System.out.print(",");
        }
        System.out.println("");
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }


    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}
