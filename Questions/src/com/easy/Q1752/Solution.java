package com.easy.Q1752;

public class Solution {
    public boolean check(int[] nums) {
        // 检查是否能够经过轮转变为非递减顺序
        // 等价为检查 nums 数组中是否出现 2 次以上的递减点(含最后一个与第一个的比较)
        int uptimes = 0;
        int n = nums.length;
        int prenum = nums[0];   // 记录前一个数值
        for (int i = 1; i < n; i++) {
            if (nums[i] < prenum){
                // 出现了降序
                uptimes++;
            }
            prenum = nums[i];
        }
        if (nums[0] < nums[n - 1])
            uptimes++;
        if (uptimes > 1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {3, 4, 5, 1, 2};
        boolean result1 = solution.check(nums1);
        System.out.println(result1); // 预期输出 true

        // 示例 2
        int[] nums2 = {2, 1, 3, 4};
        boolean result2 = solution.check(nums2);
        System.out.println(result2); // 预期输出 false

        // 示例 3
        int[] nums3 = {1, 2, 3};
        boolean result3 = solution.check(nums3);
        System.out.println(result3); // 预期输出 true
    }
}