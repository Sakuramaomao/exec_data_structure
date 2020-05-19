package com.lzj3.leetcode;

/**
 * 打印等腰三角形
 *
 * @Author Sakura
 * @Date 2020/5/19 22:15
 */
public class PrintTriangle {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 4 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                if (k % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
