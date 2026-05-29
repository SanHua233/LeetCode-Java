package com.easy.Q3300;

public class Solution {
    public int minElement(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = 0;
            while(nums[i] > 0){
                tmp = tmp + nums[i] % 10;
                nums[i] = nums[i] / 10;
            }
            if (tmp < minNum){
                minNum = tmp;
            }
        }
        return minNum;
    }

//    public int bitSum(int x){
//        int res = 0;
//        while (x != 0){
//            res = res + x % 10;
//            x = x / 10;
//        }
//        return res;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {10, 12, 13, 14};
        int result1 = solution.minElement(nums1);
        System.out.println(result1); // 预期输出 1

        // 示例 2
        int[] nums2 = {1, 2, 3, 4};
        int result2 = solution.minElement(nums2);
        System.out.println(result2); // 预期输出 1

        // 示例 3
        int[] nums3 = {999, 19, 199};
        int result3 = solution.minElement(nums3);
        System.out.println(result3); // 预期输出 10
    }
}