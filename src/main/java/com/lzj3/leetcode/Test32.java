package com.lzj3.leetcode;

import java.util.Stack;

/**
 * 最长有效括号
 *
 * @Author Sakura
 * @Date 2020/5/7 9:20
 */
public class Test32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")())())"));
    }

    public static int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack();
        int ans = 0;

        stack.push(-1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
