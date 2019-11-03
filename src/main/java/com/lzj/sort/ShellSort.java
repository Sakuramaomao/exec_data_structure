package com.lzj.sort;

/**
 * 希尔排序。
 * <p>
 * 希尔排序是插入排序的增强版。
 * <p>
 * 时间复杂度O(nlogn)。
 * <p>
 * 插入排序有两种方式，交换式和位移式。交换式相较于位移式，耗费时间较多。
 * 同理，希尔排序也有两种方式。此处属于交换式希尔排序。
 * <p>
 * 80w排序只要0.26秒。
 * 800w排序只要2.50秒。
 * 8000w排序只要31.91秒。
 *
 * @Author Sakura
 * @Date 2019/10/12 7:43
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        //shellSort(arr);
        shellSort2(arr);
        long end = System.currentTimeMillis();
        System.out.printf("消耗时间：%f ", (end - start) / 1000.0);
    }

    /**
     * 交换式希尔排序
     * <p>
     * 80000随机数排序，耗时6.75秒。所以交换式希尔排序比较慢，
     * 要比选择和插入排序慢，但是比冒泡排序快。之所以慢，就是因为交换次数过多。
     *
     * @param arr 待排序的数组。
     */
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

    /**
     * 位移式希尔排序
     * <p>
     * 80000随机数排序，耗时0.016秒。所以位移式希尔排序是真滴快，
     * 比冒泡、选择、插入排序都要快。
     *
     * @param arr 待排序的数组。
     */
    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素开始，逐个对其所在的组进行位移式插入排序。
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int insertValue = arr[i];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && insertValue < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = insertValue;
                }
            }
        }
    }
}
