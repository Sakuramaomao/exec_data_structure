package com.lzj.sort;

/**
 * 选择排序。
 * <p>
 * 时间复杂度是O(n^2)，80000随机数排序，耗时2.26秒。所以选择排序比较冒泡排序快。
 * <p>
 * 选择排序的优化：只有当min被还要小的元素替换过位置，才会做元素位置交换的操作，否则，不用交换。
 *
 * @Author Sakura
 * @Date 2019/10/10 21:27
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {119, -2, -1, 110};
        //System.out.println("排序前：" + Arrays.toString(arr));
        // 下面是80000随机数的性能测试。
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        selectSort(arr);
        long time = System.currentTimeMillis() - startTime;
        System.out.println("8w随机数，选择排序耗时：" + time / 1000.0 + " 秒");
        //System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) { // 最后一个元素不需要排序，所以多减了一个1。
            int min = arr[i]; // 存放最小值, 假定第i个元素是最小的。
            int minIndex = i; // 存放最小值的索引，用于交换。
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (min > arr[j]) { // 如果比min还要小，则值和索引都要进行更新。
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) { // 只有当min被还要小的元素替换过位置，才会做下面的交换，否则，不用变动位置。
                arr[minIndex] = arr[i]; // 交换最小值和第i个元素的位置。
                arr[i] = min;
            }
        }

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
