package com.lzj.recursion;

/**
 * @Author Sakura
 * @Date 2020/2/10 17:19
 */
public class Frog {
    public static void main(String[] args) {
        System.out.println(frog(5));
    }

    public static int frog(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return frog(n - 1) + frog(n - 2);
    }
}
