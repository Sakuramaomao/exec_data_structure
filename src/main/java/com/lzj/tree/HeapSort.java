package com.lzj.tree;

/**
 * 树的应用。堆排序。
 * <p>
 * 注意：
 * 升序使用大顶堆，降序使用小顶堆。
 * <p>
 * 80w排序只要0.14秒。
 * 800w排序只要2.23秒。
 * 8000w排序只要29秒。
 *
 * @Author Sakura
 * @Date 2019/11/3 11:55
 */
public class HeapSort {
    public static void main(String[] args) {
        //int[] arr = {4, 6, 8, 5, 9};
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("消耗时间：%f ", (end - start) / 1000.0);
    }

    public static void heapSort(int[] arr) {
        //adjustHeap(arr, 1, arr.length);
        //adjustHeap(arr, 0, arr.length);

        // 将无序数组构造为一个大顶堆。那么，整个数组的最大值就是树的根节点。
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 将最大值与数组末尾的元素交换，此时末尾就是最大值。
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            // 对剩下的n-1个元素继续构造大顶堆，得到次小值，如此反复执行，就得到了有序序列。
            adjustHeap(arr, 0, j);
        }
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 将无序数组构造为一个大顶堆。
     *
     * @param arr    无序数组。
     * @param i      表示非叶子节点在数组中的索引。
     * @param length 表示对多少个元素进行调整。length是变化的，而且是不断减少的。
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 先取出当前元素的值，保存到临时变量。

        // 从下往上调整。假定下面的调整完成，但是继续调整上面的时候，会影响下面已经调整完成的子树。
        // 这也是此处使用循环的目的。
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 注意这个变化的length。一不小心就犯错了，调试一下午。。。
            if ((k + 1) < length && arr[k] < arr[k + 1]) { // 比较左右子节点。此时k代表较大的那个节点。
                k++;
            }
            if (arr[k] > temp) { // 将较大的值和父节点的值比较。
                arr[i] = arr[k]; // 将较大的值放到父节点的位置。
                i = k; // 因为这个子树的调整会影响下面的子树，所以要对下面的子树也要进行检查和堆调整。
            } else {
                break;
            }
            arr[k] = temp;
        }
    }
}
