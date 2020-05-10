package com.lzj3.leetcode;

import java.util.Stack;

/**
 * 括号匹配。
 *
 * @Author Sakura
 * @Date 2020/5/7 8:57
 */
public class Test20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            char top = stack.peek();
            if (top == '(' && arr[i] == ')') {
                stack.pop();
            } else if (top == '[' && arr[i] == ']') {
                stack.pop();
            } else if (top == '{' && arr[i] == '}') {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
