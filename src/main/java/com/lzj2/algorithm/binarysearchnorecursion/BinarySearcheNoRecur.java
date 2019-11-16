package com.lzj2.algorithm.binarysearchnorecursion;

/**
 * 二分查找的非递归实现。
 *
 * @Author Sakura
 * @Date 2019/11/16 17:47
 */
public class BinarySearcheNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 8);
        System.out.println("index=" + index);
    }

    /**
     * 二分查找的非递归实现。
     *
     * @param arr    待查询的数组。
     * @param target 待查询的值。
     * @return 如果找到，返回元素索引。如果没找到，返回 -1。
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; // 如果比中间值小，则向左。
            } else {
                left = mid + 1; // 如果比中间值大，则向右。
            }
        }
        return -1; // 如果没找到，则返回 -1。
    }
}
