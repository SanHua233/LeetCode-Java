package com.easy.Q3120;

public class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] upper = new int[26];
        int[] lower = new int[26];
        char[] str = word.toCharArray();
        for (int i = 0; i < n; i++) {
            if (str[i] >= 'a' && str[i] <= 'z'){
                lower[str[i] - 'a']++;
            }
            else{
                upper[str[i] - 'A']++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (upper[i] != 0 && lower[i] != 0){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String word1 = "aaAbcBC";
        int result1 = solution.numberOfSpecialChars(word1);
        System.out.println(result1); // 预期输出 3

        // 示例 2
        String word2 = "abc";
        int result2 = solution.numberOfSpecialChars(word2);
        System.out.println(result2); // 预期输出 0

        // 示例 3
        String word3 = "abBCab";
        int result3 = solution.numberOfSpecialChars(word3);
        System.out.println(result3); // 预期输出 1
    }
}