package com.array2.A2Q1;

import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] tmp = new int[nums.length + 1];
        for (int num : nums){
            tmp[num]++;
        }

        for (int i = 1; i < tmp.length; i++){
            if (tmp[i] == 1){
                continue;
            }
            if (tmp[i] == 2){
                res[0] = i;
            }
            else{
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 2, 4};
        int[] result1 = solution.findErrorNums(nums1);
        System.out.println(Arrays.toString(result1)); // 预期输出 [2, 3]

        // 示例 2
        int[] nums2 = {1, 1};
        int[] result2 = solution.findErrorNums(nums2);
        System.out.println(Arrays.toString(result2)); // 预期输出 [1, 2]
    }
}