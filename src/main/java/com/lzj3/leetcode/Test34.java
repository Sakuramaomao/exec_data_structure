package com.lzj3.leetcode;

import java.util.Arrays;

/**
 * @Author Sakura
 * @Date 2020/1/26 12:12
 */
public class Test34 {
    public static void main(String[] args) {
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {1};
        int[] solution = solution(nums, 1);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] nums, int target) {
        int[] targetRange = new int[2];
        int len = nums.length;
        int first = -1;
        int last = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }

        if (first == -1) {
            targetRange[0] = first;
            targetRange[1] = last;
            return targetRange;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }
        targetRange[0] = first;
        targetRange[1] = last;
        return targetRange;
    }
}
