package com.array1.A1Q1;

import java.util.Arrays;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // 前半部分
            ans[i + n] = nums[i];   // 后半部分
        }
        return ans;
    }

    // 本地测试用的 main 方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 1};
        int[] result1 = solution.getConcatenation(nums1);
        System.out.println(Arrays.toString(result1)); // 预期输出 [1,2,1,1,2,1]

        // 示例 2
        int[] nums2 = {1, 3, 2, 1};
        int[] result2 = solution.getConcatenation(nums2);
        System.out.println(Arrays.toString(result2)); // 预期输出 [1,3,2,1,1,3,2,1]

    }
}