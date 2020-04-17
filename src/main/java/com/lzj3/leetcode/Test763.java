package com.lzj3.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 *
 * @Author Sakura
 * @Date 2020/4/14 10:08
 */
public class Test763 {
    public static void main(String[] args) {

    }

    public static List<Integer> partitionLabels(String S) {
        char[] chs = S.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
