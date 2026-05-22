package com.array2.A2Q3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 1];
        for (int i = 1;i < n + 1; i++){
            tmp[i] = i;
        }
        for (int num : nums) {
            tmp[num] = 0;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (tmp[i] != 0){
                res.add(tmp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println(result1); // 预期输出 [5, 6]

        // 示例 2
        int[] nums2 = {1, 1};
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println(result2); // 预期输出 [2]
    }
}