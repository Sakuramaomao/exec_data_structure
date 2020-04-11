package com.lzj3.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算两数之和。
 * 使用hash将复杂度降低至o(n)。
 *
 * @Author Sakura
 * @Date 2020/4/11 15:58
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] resultArr = twoSum(nums, target);
        System.out.println(Arrays.toString(resultArr));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
