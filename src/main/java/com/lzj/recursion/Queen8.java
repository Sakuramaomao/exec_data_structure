package com.lzj.recursion;

/**
 * 递归回溯求解八皇后问题。
 * <p>
 * 注意：
 * （1）数组的设计很巧妙。
 * （2）judge判断是否同一列或同一斜线也很巧妙。
 *
 * @Author Sakura
 * @Date 2019/10/8 21:39
 */
public class Queen8 {
    static int max = 8;
    // 每个皇后独占一行，第i个元素表示第i行，也表示第i个皇后。皇后所在的列用arr[i]表示。
    static int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.printf("总次数为：%d ", count);
    }

    /**
     * 编写一个方法，放置第n个皇后。
     */
    private static void check(int n) {
        if (n == max) { // n为第九个皇后时，说明前8个已经就位，结束。
            print();
            return;
        }
        for (int i = 0; i < max; i++) { // 依次放入皇后，并检测是否冲突。
            arr[n] = i; // 先将皇后放在该行的第一列。
            if (judge(n)) { // 第n个皇后不和前面的皇后冲突。
                check(n + 1); // 接着放第n+1个，开始递归。
            }
            // 如果冲突，就继续执行arr[n] = i; 即将第n个皇后，放置在本行的后移的一个位置。
        }
    }

    /**
     * 判断第n个皇后是否和之前的皇后同一列、同一斜线。
     *
     * @param n 第n个皇后。
     * @return true：不违规； false：违规。
     */
    private static boolean judge(int n) {
        boolean res = true;
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n]：是否在同一列。
            // Math.abs(n - i) == Math.abs(arr[n] - arr[i])：行距是否等于列距，即斜率是否为1来判断是否在同一斜线。
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                res = false;
            }
        }
        return res;
    }

    private static void print() {
        count++;
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
