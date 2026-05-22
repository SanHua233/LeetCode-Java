package com.array1.A1Q2;

import java.util.Arrays;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for(int i = 0; i < 2 * n; i++){
            if (i < n){     // x
                res[2 * i] = nums[i];
            }
            else {  // y
                int t = i - n;
                res[2 * t + 1] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        int[] result1 = solution.shuffle(nums1, n1);
        System.out.println(Arrays.toString(result1)); // 预期 [2,3,5,4,1,7]

        // 示例 2
        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] result2 = solution.shuffle(nums2, n2);
        System.out.println(Arrays.toString(result2)); // 预期 [1,4,2,3,3,2,4,1]

        // 示例 3
        int[] nums3 = {1, 1, 2, 2};
        int n3 = 2;
        int[] result3 = solution.shuffle(nums3, n3);
        System.out.println(Arrays.toString(result3)); // 预期 [1,2,1,2]
    }
}