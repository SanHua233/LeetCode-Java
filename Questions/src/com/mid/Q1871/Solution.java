package com.mid.Q1871;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] CR = new boolean[n];
        char[] str = s.toCharArray();
        CR[0] = true;  // str[0] 一定可达
        int left = 0;
        int right;

        for (int i = 0; i < n; i++) {
            if (CR[i]){
                // 当前节点可达
                right = Math.min(i + maxJump, n - 1);
                left = Math.max(left, i + minJump);

                while (left <= right){
                    if (str[left] == '0'){
                        // 可落脚
                        CR[left] = true;
                    }
                    left++;
                    if (left == n)
                        break;
                }
            }
        }
        return CR[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "011010";
        int minJump1 = 2;
        int maxJump1 = 3;
        boolean result1 = solution.canReach(s1, minJump1, maxJump1);
        System.out.println(result1); // 预期输出 true

        // 示例 2
        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;
        boolean result2 = solution.canReach(s2, minJump2, maxJump2);
        System.out.println(result2); // 预期输出 false

        // 示例 3
        String s3 = "0111111111111111111111111111111101111101111111111111111110";
        int minJump3 = 5;
        int maxJump3 = 26;
        boolean result3 = solution.canReach(s3, minJump3, maxJump3);
        System.out.println(result3); // 预期输出 false

        // 示例 4
        String s4 = "00";
        int minJump4 = 1;
        int maxJump4 = 1;
        boolean result4 = solution.canReach(s4, minJump4, maxJump4);
        System.out.println(result4); // 预期输出 false
    }
}