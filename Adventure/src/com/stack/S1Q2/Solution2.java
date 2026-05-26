package com.stack.S1Q2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int evalRPN(String[] tokens) {
        // 解法思路：数字进栈，符号则从数字栈中取两个进行运算，然后结果入栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            // 判断是否为运算符：长度为1且是 "+-*/" 之一
            if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1) {
                int b = stack.pop();  // 注意先弹出右操作数
                int a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            } else {
                // 数字直接入栈
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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