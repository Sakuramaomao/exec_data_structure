package com.lzj2.algorithm.dac;

/**
 * 分治算法的经典案例。
 * 汉诺塔。
 * <p>
 * 分治算法的原理理解起来很容易，但是对于一个大问题，
 * 如何拆解为容易求解的子问题是难点。汉诺塔是分治算法的经典案例，
 * 要仔细品位。
 *
 * @Author Sakura
 * @Date 2019/11/16 19:29
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 分治算法经典案例，汉诺塔。
     *
     * @param num 圆盘的个数。
     * @param a   柱子 a
     * @param b   柱子 b
     * @param c   柱子 c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘: " + a + "->" + c); // 只有一个盘时，直接从a移动到c就完事了。
        } else {
            // 当大于1一个盘时，有一个通用的规律。
            // 无论有多少个盘，这个问题总是可以看做只有两个盘，1、最下面的盘。2、除了最下面的盘以外的上面的盘。
            // 并且，也都可以用以下三步来解决。
            // 第一步：将上面的盘移动到b柱子。
            hanoiTower(num - 1, a, c, b);
            // 第二步：将最下面的盘移动到c柱子。
            System.out.println("第" + num + "个盘: " + a + "->" + c);
            // 第三步：将b柱上的盘移动到c柱子。
            hanoiTower(num - 1, b, a, c);
        }
    }
}
