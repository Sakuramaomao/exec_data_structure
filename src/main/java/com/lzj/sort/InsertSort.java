package com.lzj.sort;

/**
 * 插入排序。
 * <p>
 * 时间复杂度O(n^2)，80000随机数排序，耗时0.676秒。所以插入排序比较选择和冒泡排序都要快。
 * <p>
 * 思路：
 * 将无序数组分为有序段和无序段来看，从无序段中元素逐个取出，放入有序段中进行排序。
 *
 * @Author Sakura
 * @Date 2019/10/11 8:11
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {5, 4, 3, 2, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long startTime = System.currentTimeMillis();
        insertSort(arr);
        long time = System.currentTimeMillis() - startTime;
        System.out.println("8w随机数，插入排序耗时：" + time / 1000.0 + " 秒");
        //System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; // 无序列表中待排序的第一个元素。
            int insertIndex = i - 1; // 这个元素在有序列表中应该在的位置。这里是假定在有序列表的末尾。
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) { // 如果一直没有找到合适的位置。
                arr[insertIndex + 1] = arr[insertIndex]; // 后移
                insertIndex--;
            }
            // 上面循环结束后，插入位置就在insertIndex+1的位置。
            arr[insertIndex + 1] = insertVal;
        }
    }
}
