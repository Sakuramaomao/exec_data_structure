package com.lzj3.leetcode;

/**
 * 字符串转整数
 *
 * @Author Sakura
 * @Date 2020/5/3 15:11
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    public static int myAtoi(String str) {
        // 处理前导空格
        char[] array = str.toCharArray();
        int n = array.length;
        int idx = 0;
        while (idx != n) {
            if (' ' == array[idx]) {
                idx++;
            } else {
                break;
            }
        }

        if (idx == n) {
            // 处理完到了末尾
            return 0;
        }

        // 处理正负号
        boolean negative = false;
        if (array[idx] == '-') {
            negative = true;
            idx++;
        } else if (array[idx] == '+') {
            idx++;
        } else if (Character.isDigit(array[idx])) {
            // 其他符号
            return 0;
        }

        // 识别数字，注意越界情况。
        int ans = 0;
        while (idx < n && Character.isDigit(array[idx])) {
            int digit = array[idx] - '0';
            // 检测越界。
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
