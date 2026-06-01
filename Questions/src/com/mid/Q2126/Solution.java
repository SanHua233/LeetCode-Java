package com.mid.Q2126;

import java.util.Arrays;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long lmass = mass;
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (lmass >= asteroid) {
                lmass += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int mass1 = 10;
        int[] asteroids1 = {3, 9, 19, 5, 21};
        boolean result1 = solution.asteroidsDestroyed(mass1, asteroids1);
        System.out.println(result1); // 预期输出 true

        // 示例 2
        int mass2 = 5;
        int[] asteroids2 = {4, 9, 23, 4};
        boolean result2 = solution.asteroidsDestroyed(mass2, asteroids2);
        System.out.println(result2); // 预期输出 false
    }
}