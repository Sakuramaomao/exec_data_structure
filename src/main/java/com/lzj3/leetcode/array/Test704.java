package com.lzj3.leetcode.array;

/**
 * @Author Sakura
 * @Date 2020/1/27 10:44
 */
public class Test704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int res = search(nums, 9);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
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

        return -1;
    }
}
