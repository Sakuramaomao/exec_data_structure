package com.lzj.sort;

/**
 * 基数排序（桶排序）
 * <p>
 * 基数排序执行多少趟，取决于数组中元素最大值的位数，如果最大值是748，那么要执行3趟排序。
 * <p>
 * 基数排序是典型的用空间换取时间的排序算法。
 * 当排序数达到8千万时，所需的heap内存为至少3.27GB，运行会内存溢出。
 * 当排序数只是8万时，算法仅消耗0.067s，还是非常的快的。
 *
 * @Author Sakura
 * @Date 2019/10/18 8:08
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
        int[] arr = new int[800000];
        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 = 3.27GB
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("消耗时间：%f", (end -start) / 1000.0);
//        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        // 创建10个桶，只能确定行数，列数固定为数组长度。
        int[][] bucket = new int[10][arr.length];
        // 用来记录每个桶中元素的个数。
        int[] bucketElemCount = new int[10];

        // 1、获取数组中最大值元素
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
//        System.out.println(max);

        // 2、获取最大值的位数，用来决定排序几趟。
        int sortTimes = String.valueOf(max).length();

        // 3、排序
        for (int k = 0, n = 1; k < sortTimes; k++, n *= 10) {
            // 入桶
            for (int i = 0; i < arr.length; i++) {
                // 遍历个位
                int item = arr[i] / n % 10;
                bucket[item][bucketElemCount[item]] = arr[i]; // 放入第item个桶中。
                bucketElemCount[item]++; // 记录每个桶中的元素个数。
            }

            // 出桶
            int t = 0;
            for (int i = 0; i < bucketElemCount.length - 1; i++) { // 第i个桶
                if (bucketElemCount[i] != 0) {
                    for (int j = 0; j < bucketElemCount[i]; j++) { // 取出桶中元素放回原来的数组。
                        arr[t++] = bucket[i][j];
                    }
                }
                bucketElemCount[i] = 0; // 将每个桶中的元素数量记录清空，用来给下一趟排序使用。
            }
        }

//        // 第一趟
//        // 入桶
//        for (int i = 0; i < arr.length; i++) {
//            // 遍历个位
//            int item = arr[i] / 1 % 10;
//            bucket[item][bucketElemCount[item]] = arr[i]; // 放入第item个桶中。
//            bucketElemCount[item]++; // 记录每个桶中的元素个数。
//        }
//
//        // 出桶
//        int k = 0;
//        for (int i = 0; i < bucketElemCount.length - 1; i++) { // 第i个桶
//            if (bucketElemCount[i] != 0) {
//                for (int j = 0; j < bucketElemCount[i]; j++) { // 取出桶中元素放回原来的数组。
//                    arr[k++] = bucket[i][j];
//                }
//            }
//            bucketElemCount[i] = 0; // 将每个桶中的元素数量记录清空，用来给下一趟排序使用。
//        }
    }
}
