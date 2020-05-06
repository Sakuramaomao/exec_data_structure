package com.lzj3.leetcode;

import java.util.Stack;

/**
 * 整数反转
 *
 * @Author Sakura
 * @Date 2020/5/3 10:41
 */
public class Test7 {
    public static void main(String[] args) {
        //System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse2(-109));
    }

    public static int reverse2(int x) {
        if (x == 0) {
            return 0;
        }
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // 判断溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse(int x) {
        Stack<Character> stack = new Stack();
        // 0
        if (x == 0) {
            return 0;
        }
        String xStr;
        if (x > 0) {
            xStr = "+" + x;
        } else {
            xStr = String.valueOf(x);
        }
        char[] array = xStr.toCharArray();

        // 倒序
        char sign = array[0];
        for (int i = 1; i < array.length; i++) {
            stack.push(array[i]);
        }

        StringBuilder result = new StringBuilder(String.valueOf(sign));
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return check(result.toString());

    }

    private static int check(String result) {
        //反转后超过MAXVALUE，至0。否则，返回反转结果。
        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return 0;
        }
        return Integer.parseInt(result);
    }
}
