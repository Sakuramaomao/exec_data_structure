package com.lzj.sort;

import java.util.Arrays;

/**
 * 选择排序。
 *
 * @Author Sakura
 * @Date 2019/10/10 21:27
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {119, -2, -1, 110};
        System.out.println("排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 2; i++) { // 最后一个元素不需要排序，所以多减了一个1。
            int min = arr[i]; // 存放最小值, 假定第i个元素是最小的。
            int minIndex = i; // 存放最小值的索引，用于交换。
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (min > arr[j]) { // 如果比min还要小，则值和索引都要进行更新。
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i]; // 交换最小值和第i个元素的位置。
            arr[i] = min;
        }

        System.out.println("排序后：" + Arrays.toString(arr));

        // 以下为由简到繁的推导过程，如果忘记了可以看下面的注释。
        //// 第一趟排序。
        //int min = arr[0]; // 存放最小值, 假定第一个元素是最小的。
        //int minIndex = 0; // 存放最小值所在的索引，用来交换位置。
        //for (int j = 0 + 1; j < arr.length - 1; j++) {
        //    if (min > arr[j]) { // 说明min不是最小的，要将min更新，并记录下min所在的index。
        //        min = arr[j];
        //        minIndex = j;
        //    }
        //} // 比较完后，就得到了最小的值。
        //
        //arr[minIndex] = arr[0]; // 将第一个元素和最小值交换位置。
        //arr[0] = min;
        //
        //System.out.println("第一趟交换：" + Arrays.toString(arr));
        //
        //// 第一趟排序。
        //int min2 = arr[1]; // 存放最小值, 假定第一个元素是最小的。
        //int minIndex2 = 1; // 存放最小值所在的索引，用来交换位置。
        //for (int j = 1 + 1; j < arr.length - 1; j++) {
        //    if (min2 > arr[j]) { // 说明min不是最小的，要将min更新，并记录下min所在的index。
        //        min2 = arr[j];
        //        minIndex2 = j;
        //    }
        //} // 比较完后，就得到了最小的值。
        //
        //arr[minIndex2] = arr[1]; // 将第一个元素和最小值交换位置。
        //arr[1] = min2;
        //
        //System.out.println("第二趟交换：" + Arrays.toString(arr));
    }
}
