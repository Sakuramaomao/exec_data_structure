package com.lzj3.leetcode;

/**
 * 盛水最多的容器
 *
 * @Author Sakura
 * @Date 2019/12/17 21:00
 */
public class Test11 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxArea(arr);
        System.out.println(res);
        int i = maxArea2(arr);
        System.out.println(i);
    }

    // 双指针法。
    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {

                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }

    // 暴力求解
    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int dist = j - i;
                int min = height[i];
                if (height[j] < height[i]) {
                    min = height[j];
                }
                int maxTmp = dist * min;
                if (maxTmp > max) {
                    max = maxTmp;
                }
            }
        }
        return max;
    }
}
