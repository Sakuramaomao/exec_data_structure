package com.lzj.sort;

import java.util.Arrays;

/**
 * 希尔排序。
 * <p>
 * 希尔排序是插入排序的增强版。
 * 
 * 插入排序有两种方式，交换式和位移式。交换式相较于位移式，耗费时间较多。
 * 同理，希尔排序也有两种方式。此处属于交换式希尔排序。
 *
 * @Author Sakura
 * @Date 2019/10/12 7:43
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("消耗时间：%f ", (end - start) / 1000.0);
    }

    private static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
