package com.mid.Q3121;

public class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] upper = new int[26];
        int[] lower = new int[26];
        char[] str = word.toCharArray();
        for (int i = 0; i < n; i++) {
            // 记录各字母出现的位置，因为要求每个小写的出现在大写的前，所以统计小写最后一次出现与大写第一次出现
            if (str[i] >= 'a' && str[i] <= 'z'){
                lower[str[i] - 'a'] = i + 1;
            }
            else{
                if (upper[str[i] - 'A'] == 0)
                    upper[str[i] - 'A'] = i + 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            // 大小写都出现 并且小写在大写前面
            if (upper[i] != 0 && lower[i] != 0 && lower[i] < upper[i]){
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
        String word3 = "cCceDC";
        int result3 = solution.numberOfSpecialChars(word3);
        System.out.println(result3); // 预期输出 0
    }
}