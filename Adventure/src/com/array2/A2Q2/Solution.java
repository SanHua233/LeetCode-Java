package com.array2.A2Q2;

import java.util.Arrays;
/*
    hint:
    0 <= nums[i] <= 100
    2 <= nums.length <= 500
 */

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buk = new int[101];
        for(int num:nums){
            buk[num]++;
        }
        int n = nums.length;
        int[] append = new int[101];
        int[] res = new int[n];
        append[0] = 0;
        for (int i = 1; i < 101; i++) {
            append[i] = append[i-1] + buk[i-1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = append[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {8, 1, 2, 2, 3};
        int[] result1 = solution.smallerNumbersThanCurrent(nums1);
        System.out.println(Arrays.toString(result1)); // 预期输出 [4,0,1,1,3]

        // 示例 2
        int[] nums2 = {6, 5, 4, 8};
        int[] result2 = solution.smallerNumbersThanCurrent(nums2);
        System.out.println(Arrays.toString(result2)); // 预期输出 [2,1,0,3]

        // 示例 3
        int[] nums3 = {7, 7, 7, 7};
        int[] result3 = solution.smallerNumbersThanCurrent(nums3);
        System.out.println(Arrays.toString(result3)); // 预期输出 [0,0,0,0]

        // 示例 4
        int[] nums4 = {5,0,10,0,10,6};
        int[] result4 = solution.smallerNumbersThanCurrent(nums4);
        System.out.println(Arrays.toString(result4)); // 预期输出 [2,0,4,0,4,3]
    }
}