package com.lzj3.leetcode;

import java.util.Arrays;

/**
 * @Author Sakura
 * @Date 2020/1/27 11:06
 */
public class Test34_2 {
    public static void main(String[] args) {
        //int[] nums = {-1, 0, 9, 9, 9, 12};
        int[] nums = {2, 2};
        //int leftBound = leftBound(nums, 10);
        //System.out.println(leftBound);
        //int rightBound = rightBound(nums, 10);
        //System.out.println(rightBound);
        int[] solution = solution(nums, 3);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] nums, int target) {
        int leftBound = -1;
        int rightBound = -1;
        int[] range = new int[2];
        range[0] = leftBound;
        range[1] = rightBound;

        if (nums.length == 0) {
            return range;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left == nums.length) {
            leftBound = -1;
        } else {
            leftBound = nums[left] == target ? left : -1;
        }
        if (leftBound == -1) {
            return range;
        } else {
            range[0] = leftBound;

            left = 0;
            right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            rightBound = nums[left - 1] == target ? left - 1 : -1;
            range[1] = rightBound;
        }
        return range;
    }

    public static int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}