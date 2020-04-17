package com.lzj3.leetcode;

/**
 * 查找字符串数组中的最长公共前缀。
 *
 * @Author Sakura
 * @Date 2020/4/14 8:39
 */
public class Test14 {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) return "";
        if (length == 1) return strs[0];

        String res = strs[0];
        if ("".equals(res)) return res;
        for (int i = 1; i < length; i++) {
            if ("".equals(strs[i])) return "";

            int start = 0;
            String next = strs[i];
            while (start < strs[i].length()) {
                if (start < res.length() && res.charAt(start) == (next.charAt(start))) {
                    start++;
                } else {
                    break;
                }
            }
            res = res.substring(0, start);
        }

        return res;
    }
}
