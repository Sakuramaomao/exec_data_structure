package com.lzj.search;

/**
 * 插值查找算法。
 * <p>
 * 注意：
 * 对于数值分布均匀的数组，插值查找速度比二分查找快。
 * 反之，二分查找速度要比插值查找速度快。
 *
 * @Author Sakura
 * @Date 2019/10/20 15:18
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = insertValueSearch(arr, 0, arr.length - 1, 10);
        System.out.println(result);
    }

    /**
     * 插值查找的基本写法。使用递归。
     *
     * @param arr     分布均匀的有序数组
     * @param left    左边的下标
     * @param right   右边的下标
     * @param findVal 查找的值
     * @return 待查找值的下标
     */
    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("查找次数~");
        // 这里必须添加额外的两个判定，一方面可以加快算法速度，另一方面，可以保证计算出的mid始终是有效的。
        // 如果不添加，mid可能会越界。
        if (left > right || findVal < arr[0] || findVal > arr[right]) {
            return -1;
        }
        // 相比二分查找，最重要的即是增加了这个自适应mid值。
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 向右找
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else { // findVal == midVal, 说明找到了，直接返回。
            return mid;
        }
    }
}
