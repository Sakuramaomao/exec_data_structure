package com.lzj.sort;

/**
 * 冒泡排序。
 * <p>
 * 冒泡排序需要arr.length - 1趟排序，之所以减一，是因为每趟排序都会将最大值放置到最后，
 * 而最后一个元素不需要排序了，少一趟。
 * <p>
 * 时间复杂度是O(n^2).
 * <p>
 * 冒泡排序的优化：如果某一趟排序过程中并没有发生交换，那么表示数组已然有序，直接停止排序。
 *
 * @Author Sakura
 * @Date 2019/10/9 22:38
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {3, 10, -1, 9, 20};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        //System.out.println("排序前顺序：" + Arrays.toString(arr));
        bubbleSort(arr);
        //System.out.println("排序后顺序：" + Arrays.toString(arr));
        long time = System.currentTimeMillis() - startTime;
        System.out.println("耗时：" + time / 1000 + " s");
    }

    private static void bubbleSort(int[] arr) {
        int size = arr.length;
        int temp;  // 用于交换。
        boolean flag = false; // 表示是否发生过交换。
        for (int i = 0; i < size - 1; i++) { // size - 1 趟
            for (int j = 0; j < size - 1 - i; j++) { // 每一趟中比较的元素都在减少，比较的次数也在减少。
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) { // 如果未发生交换，说明数组已然有序，结束排序。
                break;
            } else {
                flag = false; // 如果这一趟发生过交换，那么要记得将flag初始化，因为下一趟排序需要使用。
            }
            //展示排序的过程。
            //System.out.println("第 " + (i + 1) + " 趟排序结果为：" + Arrays.toString(arr));
        }
    }
}
