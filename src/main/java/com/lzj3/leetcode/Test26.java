package com.lzj3.leetcode;

/**
 * @Author Sakura
 * @Date 2019/12/17 21:25
 */
public class Test26 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int slowCur = 0;

        int len = nums.length;
        for (int fastCur = 1; fastCur < len; fastCur++) {
            if (nums[fastCur] == nums[slowCur]) {
                continue;
            } else {
                slowCur++;
                nums[slowCur] = nums[fastCur];
            }
        }

        return slowCur + 1;
    }
}
