package com.lzj.queue;

import java.util.Scanner;

/**
 * 数组环形队列测试。
 * <p>
 * 这一次的环形队列解决了一次性数组的问题。
 *
 * @Author Sakura
 * @Date 2019/9/23 21:48
 */
public class CycleArrayQueueTest {
    public static void main(String[] args) {
        CycleArrayQueue q = new CycleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a(add) 向队列添加元素");
            System.out.println("g(get) 获取队头元素");
            System.out.println("s(show) 查看队列");
            System.out.println("h(head) 查看队头元素");
            System.out.println("e(exit) 退出");
            switch (scanner.next()) {
                case "a":
                    System.out.println("输入一个值：");
                    try {
                        q.add(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "g":
                    try {
                        System.out.println("队头元素为：" + q.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    q.show();
                    break;
                case "h":
                    try {
                        System.out.println("队头元素的值为：" + q.head());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    loop = false;
                    scanner.close();
                    System.out.println("GoodBye User");
                    break;
            }
        }
    }
}
