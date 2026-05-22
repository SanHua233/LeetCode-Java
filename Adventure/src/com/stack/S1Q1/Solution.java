package com.stack.S1Q1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (target[idx] == i){
                result.add("Push");
                idx++;
            }
            else{
                result.add("Push");
                result.add("Pop");
            }
            if (idx == target.length){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] target1 = {1, 3};
        int n1 = 3;
        List<String> result1 = solution.buildArray(target1, n1);
        System.out.println(result1); // 预期输出 [Push, Push, Pop, Push]

        // 示例 2
        int[] target2 = {1, 2, 3};
        int n2 = 3;
        List<String> result2 = solution.buildArray(target2, n2);
        System.out.println(result2); // 预期输出 [Push, Push, Push]

        // 示例 3
        int[] target3 = {1, 2};
        int n3 = 4;
        List<String> result3 = solution.buildArray(target3, n3);
        System.out.println(result3); // 预期输出 [Push, Push]
    }
}