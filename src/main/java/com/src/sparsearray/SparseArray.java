package com.src.sparsearray;

/**
 * 二维数据和稀疏数组之间的转换。
 *
 * @Author Sakura
 * @Date 2019/9/16 23:03
 */
public class SparseArray {
    public static void main(String[] args) {
        // 1、原始二维数组。0表示无，1表示黑子，2表示蓝子。
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[3][3] = 2;
        printArray(array, "原二维数组");

        // 2、二维数组转化为稀疏数组
        int sum = getSum(array);
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] != 0) {
                        count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        printArray(sparseArray, "转化为稀疏数组");

        // 3、稀疏数组转化为二维数组
        int[][] array2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        int sparseRow = sparseArray.length;
        for (int i = 1; i < sparseRow; i++) {
           array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        printArray(array2, "转化为原数组");
    }

    private static int getSum(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void printArray(int[][] array, String message) {
        System.out.println("=====" + message + "======");
        for (int[] row : array) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
