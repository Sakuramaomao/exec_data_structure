package com.lzj.kmp;

/**
 * 字符串暴力匹配算法。
 *
 * @Author Sakura
 * @Date 2019/11/24 11:27
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "bcde";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    /**
     * 字符串暴力匹配算法。
     *
     * @param str1 原字符串。
     * @param str2 待匹配的子串。
     * @return 如果匹配到，返回子串在原字符串中的初始位置下标。否则，返回 -1。
     */
    public static int violenceMatch(String str1, String str2) {
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();

        int str1Len = str1.length();
        int str2Len = str2.length();

        int i = 0; // 对原字符串数组遍历的指针。
        int j = 0; // 对子串数组遍历的指针。

        while (i < str1Len && j < str2Len) { // 先保证两个数组都不越界。
            if (str1CharArr[i] == str2CharArr[j]) { // 匹配ok
                i++;
                j++;
            } else { // 没有匹配成功，就要回溯。
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == str2Len) { // 如果找到子串，返回下标。
            return i - j;
        } else {
            return -1; // 如果未找到，返回 -1。
        }
    }
}
