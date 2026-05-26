package com.stack.S1Q2;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        // 解法思路：数字进栈，符号则从数字栈中取两个进行运算，然后结果入栈
        Stack<Integer> numStack = new Stack<>();    // 数字栈
        int num1, num2, res;
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            // 数字进栈
            if (isNum(tokens[i])){
                numStack.add(Integer.parseInt(tokens[i]));
            }
            // 符号出栈
            else{
                num2 = numStack.pop();
                num1 = numStack.pop();
                numStack.add(cala(num1, num2, tokens[i]));
            }
        }
        return numStack.pop();
    }

    public boolean isNum(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^-?\\d+$");
    }

    public int cala(int n1, int n2, String sym){
        return switch (sym) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1 = solution.evalRPN(tokens1);
        System.out.println(result1); // 预期输出 9

        // 示例 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = solution.evalRPN(tokens2);
        System.out.println(result2); // 预期输出 6

        // 示例 3
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result3 = solution.evalRPN(tokens3);
        System.out.println(result3); // 预期输出 22
    }
}