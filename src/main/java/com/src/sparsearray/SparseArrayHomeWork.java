package com.src.sparsearray;

/**
 * 作业：
 *  1）在前面的基础上，将稀疏数组保存到磁盘上，比如map.data，
 *  2）恢复数组时，读取map.data进行恢复。
 *
 * @Author Sakura
 * @Date 2019/9/17 8:08
 */
public class SparseArrayHomeWork {
    public static void main(String[] args) {
        int[][] sparseArray = new int[3][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 3;
        sparseArray[1][0] = 1;
        sparseArray[1][1] = 2;
        sparseArray[1][2] = 1;
        sparseArray[2][0] = 2;
        sparseArray[2][1] = 3;
        sparseArray[2][2] = 2;
        SparseArray.printArray(sparseArray, "稀疏数组");

        persisted(sparseArray);
    }

    /**
     * 持久化稀疏数组。
     *
     * @param sparseArray 稀疏数组。
     */
    private static void persisted(int[][] sparseArray) {
        // TODO 2019/09/22 将稀疏数组持久化至硬盘。
    }
}
