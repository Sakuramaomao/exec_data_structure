package com.lzj.recursion;

/**
 * 递归练习--热身
 * <p>
 * 求n！
 *
 * @Author Sakura
 * @Date 2020/2/10 16:44
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
