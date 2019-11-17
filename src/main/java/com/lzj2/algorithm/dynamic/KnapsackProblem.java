package com.lzj2.algorithm.dynamic;

import java.util.Arrays;

/**
 * 动态规划求解背包问题。
 *
 * @Author Sakura
 * @Date 2019/11/17 16:19
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3}; // 物品的重量。
        int[] value = {1500, 3000, 2000}; // 物品的价值。
        int capacity = 4; // 背包的容量。
        int goodsNum = value.length; // 物品的个数。

        // 创建二维数组。
        // v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值。
        int[][] maxValue = new int[goodsNum + 1][capacity + 1];

        // 初始化第一行和第一列都为0，本程序中可以不做，因为默认就是0。
        for (int i = 0; i < maxValue.length; i++) {
            maxValue[i][0] = 0; // 将第一列设置为0。
        }
        for (int i = 0; i < maxValue[0].length; i++) {
            maxValue[0][i] = 0; // 将第一行设置为0。
        }

        // 根据前面填表总结出来的公式来动态规划处理。
        for (int i = 1; i < maxValue.length; i++) { // 不处理第一行，i是从1开始的。
            for (int j = 1; j < maxValue[i].length; j++) { // 不处理第一列，j是从1开始的。
                if (weight[i - 1] > j) { // 因为从1开始的，所以要对原来公式做修改。
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], value[i - 1] + maxValue[i - 1][j - weight[i - 1]]);
                }
            }
        }

        // 打印下maxValue这个二维填表。
        for (int i = 0; i < maxValue.length; i++) {
            System.out.println(Arrays.toString(maxValue[i]));
        }
    }
}
