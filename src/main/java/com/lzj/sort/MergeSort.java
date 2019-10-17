package com.lzj.sort;

/**
 * 归并排序
 *
 * 采用分而治之的思想，将数组分解后排序合并。
 * 核心部分是分递归与治合并两个有序数组。
 *
 * 时间复杂度是O(nlogn)，80000个数据的数组，耗时0.014s。
 * 算法消耗的时间主要是在合并，而归并排序合并的次数始终是（数组长度 - 1） 次。
 *
 * @Author Sakura
 * @Date 2019/10/16 8:17
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        System.out.printf("消耗时间：%f", (end -start) / 1000.0);
    }

    /**
     * 分
     *
     * 采用递归
     * left < right 为递归的判断条件，不满足时，说明已经从一边分到底了。
     *  1、算中位数
     *  2、向左分
     *  3、向右分
     *  4、合并。
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp); // 向左分
            mergeSort(arr, mid + 1, right, temp); // 向右分
            merge(arr, left, mid, right, temp); // 合并
        }
    }

    /**
     * 治
     *
     * @param arr   待排序数组
     * @param left  左边下标
     * @param mid   中下标
     * @param right 右下标
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        // 1、有序数组合并。
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 2、处理未合并完的。
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 3、拷贝到temp数据至原数组
        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            t++;
            left++;
        }
    }
}
