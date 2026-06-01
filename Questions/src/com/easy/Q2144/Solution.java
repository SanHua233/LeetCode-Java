package com.easy.Q2144;

import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost) {
        // 先排序, 然后按降序统计最大的几个糖果价格
        // 买二送一，俩大带一小，可以转化为买两个，跳过一个的问题
        Arrays.sort(cost);
        // System.out.println(Arrays.toString(cost));
        int n = cost.length;
        int res = 0, cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cnt % 3 != 2) {
                res += cost[i];
            }
            cnt++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] cost1 = {1, 2, 3};
        int result1 = solution.minimumCost(cost1);
        System.out.println(result1); // 预期输出 5

        // 示例 2
        int[] cost2 = {6, 5, 7, 9, 2, 2};
        int result2 = solution.minimumCost(cost2);
        System.out.println(result2); // 预期输出 23

        // 示例 3
        int[] cost3 = {5, 5};
        int result3 = solution.minimumCost(cost3);
        System.out.println(result3); // 预期输出 10
    }
}