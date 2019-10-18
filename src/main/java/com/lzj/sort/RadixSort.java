package com.lzj.sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序）
 * <p>
 * 基数排序执行多少趟，取决于数组中元素最大值的位数，如果最大值是748，那么要执行3趟排序。
 * <p>
 * 基数排序是典型的用空间换取时间的排序算法。
 *
 * @Author Sakura
 * @Date 2019/10/18 8:08
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        // 创建10个桶，只能确定行数，列数无法确定，只能先定这么多。
        int[][] bucket = new int[10][20];
        // 用来记录每个桶中元素的个数。
        int[] bucketElemCount = new int[10];

        // 第一趟
        // 入桶
        for (int i = 0; i < arr.length - 1; i++) {
            // 遍历个位
            int item = arr[i] % 10;
            bucket[item][bucketElemCount[item]] = arr[i]; // 放入第item个桶中。
            bucketElemCount[item]++; // 记录每个桶中的元素个数。
        }

        // 出桶
        for (int i = 0; i < bucketElemCount.length - 1; i++) {
            if (bucketElemCount[i] != 0) {
                for (int j = 0; j < bucketElemCount[i]; j++) {
                    arr[j] = bucket[i][j];
                }
            }
        }
    }
}
