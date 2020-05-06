package com.lzj3.leetcode;

import java.util.Arrays;

/**
 * 使数组唯一的最小增量。
 *
 * @Author Sakura
 * @Date 2020/5/3 18:37
 */
public class Test945 {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
    }

    public static int minIncrementForUnique(int[] A) {
        if (A.length == 0) return 0;

        Arrays.sort(A);

        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int old = A[i];
                A[i] = A[i - 1] + 1;
                ans += A[i] - old;
            }
        }
        return ans;
    }
}
