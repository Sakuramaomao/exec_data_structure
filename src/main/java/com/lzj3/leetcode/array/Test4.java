package com.lzj3.leetcode.array;

import java.util.Arrays;

/**
 * @Author Sakura
 * @Date 2019/12/17 20:26
 */
public class Test4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double mediaNum = findMedianSortedArrays(nums1, nums2);
        System.out.println(mediaNum);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并数组
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] newNums = new int[len1 + len2];
        System.arraycopy(nums1, 0, newNums, 0, len1);
        System.arraycopy(nums2, 0, newNums, len1, len2);

        // 排序
        Arrays.sort(newNums);

        // 中位数
        int newLen3 = newNums.length;
        int tmp = newLen3 / 2;
        if (newLen3 % 2 == 0) {
            return (newNums[tmp - 1] + newNums[tmp]) / 2.0;
        } else {
            return newNums[tmp];
        }
    }
}
