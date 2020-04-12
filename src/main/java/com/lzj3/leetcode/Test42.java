package com.lzj3.leetcode;

/**
 * 接雨水。
 * 暴力求解O(n2)
 *
 * @Author Sakura
 * @Date 2020/4/12 11:47
 */
public class Test42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(arr);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int count = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int size = Math.min(maxLeft, maxRight) - height[i];
            count += size;
        }
        return count;
    }
}

