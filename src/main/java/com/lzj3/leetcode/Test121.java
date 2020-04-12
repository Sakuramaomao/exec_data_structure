package com.lzj3.leetcode;

/**
 * 买卖股票的最佳时机。
 * 只是一个有特点的题目，没有什么比较普适性的解题方法。
 *
 * @Author Sakura
 * @Date 2020/4/12 12:10
 */
public class Test121 {
    public static void main(String[] args) {
        //int[] arr = {7,1,5,3,6,4};
        int[] arr = {1, 4, 2};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < minProfit) {
                minProfit = price;
            } else if (price - minProfit > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }
}
