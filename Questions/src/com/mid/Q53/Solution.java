package com.mid.Q53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
//        for (int i = 1; i < n + 1; i++) {
//            System.out.println(preSum[i]);
//        }
        int minPreSum = preSum[0];
        int maxSub = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            // 当前前缀和 - 最小前缀和(i 以前的)
            maxSub = Math.max(maxSub, preSum[i] - minPreSum);
            // 维护最小前缀和
            minPreSum = Math.min(minPreSum, preSum[i]);
        }
        return maxSub;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println(result1); // 预期输出 6

        // 示例 2
        int[] nums2 = {-1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println(result2); // 预期输出 -1

        // 示例 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println(result3); // 预期输出 23

        int[] num4 = {-1, -2, -3};
        int result4 = solution.maxSubArray(num4);
        System.out.println(result4); // -1
    }
}