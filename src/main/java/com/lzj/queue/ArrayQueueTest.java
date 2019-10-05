package com.lzj.queue;

import java.util.Scanner;

/**
 * 数组队列测试。
 * 这一版的数组队列有bug。只是一次性数组。
 *
 * @Author Sakura
 * @Date 2019/9/22 16:48
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(3);
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
                        q.addFromRear(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "g":
                    try {
                        System.out.println("队头元素为：" + q.getFromFront());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    q.show();
                    break;
                case "h":
                    try {
                        System.out.println("队头元素的值为：" + q.getHead());
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
