package com.lzj.stack;

import java.util.Scanner;

/**
 * 数组模拟栈的测试用例。
 *
 * @Author Sakura
 * @Date 2019/10/5 11:38
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);

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
                    arrayStack.list();
                    break;
                case "push":
                    arrayStack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        int value = arrayStack.pop();
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
