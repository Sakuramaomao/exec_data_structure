package com.lzj3.leetcode;

/**
 * 长度最小的子数组。
 * 连续子串求和的内容都可以使用滑动窗口来求解。
 *
 * @Author Sakura
 * @Date 2020/4/12 16:54
 */
public class Test209 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7, arr);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        int len = nums.length;

        while (right < len) {
            sum += nums[right++];
            while (sum >= s) {
                minSize = Math.min(right - left, minSize);
                sum -= nums[left++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
