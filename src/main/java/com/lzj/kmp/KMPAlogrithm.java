package com.lzj.kmp;

/**
 * @Author Sakura
 * @Date 2019/11/24 15:10
 */
public class KMPAlogrithm {
    public static void main(String[] args) {
        String str1 = "ABCDEFGHIJK";
        String str2 = "CDE";
        int index = kmpSearch(str1, str2, kmpNext(str2));
        System.out.println("index=" + index);
    }

    /**
     * 完整的kmp算法。
     *
     * @param str1 原字符串。
     * @param str2 待匹配的子串。
     * @param next 子串的部分匹配表。
     * @return 如果是 -1 ，表示没找到。否则，返回第一个匹配到的子串的首字母下标。
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 这也是kmp算法的核心。
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    // 获取到一个字符串的部分匹配值表。
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 直到 dest.charAt(i) == dest.charAt(j) 才退出。
            // 这是kmp算法的核心。
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
