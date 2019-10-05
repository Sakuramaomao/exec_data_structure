package com.lzj.stack;

import java.util.Scanner;

/**
 * 单链表模拟栈的测试用例。
 *
 * @Author Sakura
 * @Date 2019/10/5 12:40
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("list 遍历栈");
            System.out.println("push 入栈");
            System.out.println("pop 出栈");
            System.out.println("exit 退出程序");

            String key = scanner.nextLine();
            switch (key) {
                case "list":
                    linkedListStack.list();
                    break;
                case "push":
                    linkedListStack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        int value = linkedListStack.pop();
                        System.out.printf("出栈元素为 %d \n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    System.out.println("程序已退出");
                    break;
            }
        }
    }
}
