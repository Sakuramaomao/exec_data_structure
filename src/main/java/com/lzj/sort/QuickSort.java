package com.lzj.sort;

/**
 * 快速排序。
 * <p>
 * 当数据量达到8千w时，希尔排序要42s，而快速排序只需要12s。
 *
 * @Author Sakura
 * @Date 2019/10/15 21:27
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {-9, 78, 24, 23, -567, 70};
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.printf("消耗时间：%f ", (end - start) / 1000.0);
        //System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int L = left; // 左下标
        int R = right; // 右下标
        int pivot = arr[(left + right) / 2]; // 中轴值。
        int temp;

        // 从小到大排序。
        while (L < R) {
            // 找从左边找到一个大于pivot的。
            while (arr[L] < pivot) { // 都会到达pivot所在的地方。
                L++;
            }
            // 从右边开始找到一个小于pivot的。
            while (arr[R] > pivot) { // 也会到达pivot所在的地方。
                R--;
            }

            if (L >= R) { // 如果没有这个判断，在递归时会栈溢出。
                break;
            }

            // 两者交换位置。
            temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;

            if (arr[L] == pivot) { // 当任意一方先到达pivot所在的地方时，让对方错位，以退出循环。
                R--;
            }

            if (arr[R] == pivot) { // 为了保证当两边都到达pivot时，能退出循环。
                L++;
            }
        }

        if (L == R) {
            L += 1;
            R -= 1;
        }

        if (left < R) {
            quickSort(arr, left, R);
        }
        if (right > L) {
            quickSort(arr, L, right);
        }
    }
}
