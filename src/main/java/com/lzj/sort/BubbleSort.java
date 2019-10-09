package com.lzj.sort;

import java.util.Arrays;

/**
 * 冒泡排序。
 * <p>
 * 冒泡排序需要arr.length - 1趟排序，之所以减一，是因为每趟排序都会将最大值放置到最后，
 * 而最后一个元素不需要排序了，少一趟。
 *
 * @Author Sakura
 * @Date 2019/10/9 22:38
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        int size = arr.length;
        int temp;
        for (int i = 0; i < size - 1; i++) { // size - 1 趟
            for (int j = 0; j < size - 1 - i; j++) { // 每一趟中比较的元素都在减少，比较的次数也在减少。
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第 " + (i + 1) + " 趟排序结果为：" + Arrays.toString(arr));
        }
    }
}
