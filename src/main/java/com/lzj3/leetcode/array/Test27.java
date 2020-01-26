package com.lzj3.leetcode.array;

/**
 * @Author Sakura
 * @Date 2020/1/26 11:15
 */
public class Test27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int slowCur = 0;
        int len = nums.length;
        for (int fastCur = 0; fastCur < len; fastCur++) {
            if (nums[fastCur] != val) {
                nums[slowCur] = nums[fastCur];
                slowCur++;
            }
        }
        return slowCur;
    }
}
