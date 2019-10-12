package com.lzj.sort;

import java.util.Arrays;

/**
 * 希尔排序。
 * <p>
 * 希尔排序是插入排序的增强版。
 *
 * @Author Sakura
 * @Date 2019/10/12 7:43
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int temp;
        // 十个数，分成五组，每组进行比较。
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < arr.length; j += 4) {
                if (arr[j] > arr[j + 4]) {
                    temp = arr[j];
                    arr[j] = arr[j + 4];
                    arr[j + 4] = temp;
                }
            }
        }
    }
}
