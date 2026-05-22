package com.array1.A1Q3;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
                if (cnt > res) {
                    res = cnt;
                }
            } else {
                cnt = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int result1 = solution.findMaxConsecutiveOnes(nums1);
        System.out.println(result1); // 预期输出 3

        // 示例 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        int result2 = solution.findMaxConsecutiveOnes(nums2);
        System.out.println(result2); // 预期输出 2

        // 你可以在这里添加更多测试用例
    }
}