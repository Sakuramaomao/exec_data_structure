package com.lzj.sort;

/**
 * 希尔排序。
 * <p>
 * 希尔排序是插入排序的增强版。
 * <p>
 * 时间复杂度O(nlogn)，80000随机数排序，耗时6.75秒。所以交换式希尔排序比较慢，
 * 要比选择和插入排序慢，但是比冒泡排序快。
 * <p>
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
        int temp;
        // 这个可以一步一步的写。
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        // 第一趟，当步长为5时，有五组。
        //for (int i = 5; i < arr.length; i++) {
        //    for (int j = i - 5; j >= 0; j -= 5) {
        //        if (arr[j] > arr[j + 5]) {
        //            temp = arr[j];
        //            arr[j] = arr[j + 5];
        //            arr[j + 5] = temp;
        //        }
        //    }
        //}

        // 第二趟，当步长为2时，有两组。
        //for (int i = 2; i < arr.length; i++) {
        //    for (int j = i - 2; j >= 0; j -= 2) {
        //        if (arr[j] > arr[j + 2]) {
        //            temp = arr[j];
        //            arr[j] = arr[j + 2];
        //            arr[j + 2] = temp;
        //        }
        //    }
        //}

        // 第三趟，当步长为1时，只有一组，就是交换式的插入排序了。
        //for (int i = 1; i < arr.length; i++) {
        //    for (int j = i - 1; j >= 0; j -= 1) {
        //        if (arr[j] > arr[j + 1]) {
        //            temp = arr[j];
        //            arr[j] = arr[j + 1];
        //            arr[j + 1] = temp;
        //        }
        //    }
        //}
    }
}
