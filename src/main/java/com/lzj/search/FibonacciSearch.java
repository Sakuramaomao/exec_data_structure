package com.lzj.search;

import java.util.Arrays;

/**
 * 斐波那锲（黄金分割）查找算法。待实现
 *
 * @Author Sakura
 * @Date 2019/10/20 16:31
 */
public class FibonacciSearch {
    private static int maxSize = 20;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib()));
    }

    /**
     * 生成斐波那锲数列
     *
     * @return 斐波那锲数列。
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
