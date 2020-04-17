package com.lzj3.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * z型字符串
 *
 * @Author Sakura
 * @Date 2020/4/13 16:40
 */
public class Test6 {
    public static void main(String[] args) {
        // LDREOEIIECIHNTSG
        String str = "AB";
        System.out.println(convert(str, 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> res = new ArrayList<>();
        int rows = Math.min(numRows, s.length());
        for (int i = 0; i < rows; i++) {
            res.add(new StringBuilder());
        }

        boolean direction = false;
        int rowNum = 0;
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            // 当遇到起始点获取终点时，调转方向。
            if (rowNum == 0 || rowNum == (numRows - 1)) {
                direction = !direction;
            }
            res.get(rowNum).append(ch);
            // 向下
            if (direction) {
                rowNum++;
            } else {
                rowNum--;
            }
        }
        StringBuilder builder = new StringBuilder();
        res.forEach(b -> builder.append(b));
        return builder.toString();
    }
}
