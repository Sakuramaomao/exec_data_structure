package com.lzj3.leetcode.array;

/**
 * @Author Sakura
 * @Date 2020/1/27 13:16
 */
public class Test35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int solution = solution(nums, 7);
        System.out.println(solution);
    }

    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return left;
    }
}
