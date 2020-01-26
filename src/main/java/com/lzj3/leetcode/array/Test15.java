package com.lzj3.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Sakura
 * @Date 2020/1/12 15:35
 */
public class Test15 {
    public static void main(String[] args) {
        //int[] nums = {-2, -3, 0, 0, -2};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;

        for (int k = 0; k < len - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s < 0) {
                    while (i < j && nums[i] == nums[++i]) {
                    }
                } else if (s > 0) {
                    while (i < j && nums[j] == nums[--j]) {
                    }
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[k]);
                    res.add(nums[i]);
                    res.add(nums[j]);
                    lists.add(res);
                    while (i < j && nums[i] == nums[++i]) {
                    }
                    while (i < j && nums[j] == nums[--j]) {
                    }
                }
            }
        }
        return lists;
    }
}
