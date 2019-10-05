package com.lzj.stack;

/**
 * 使用数组模拟栈。
 *
 * @Author Sakura
 * @Date 2019/10/5 11:28
 */
public class ArrayStack {
    private int maxSize; // 栈的最大容量。
    private int top = -1; // 栈顶指针，初始为 -1。
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 入栈。
     * <p>
     * 从栈顶入。
     *
     * @param e 待添加元素。
     */
    public void push(int e) {
        if (isFull()) {
            System.out.println("栈满，无法入栈");
            return;
        }
        top++;
        stack[top] = e;
    }

    /**
     * 出栈。
     * <p>
     * 从栈顶出。
     *
     * @return 栈顶元素。
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 查看栈顶元素（偷瞄一下栈顶，并非出栈）。
     *
     * @return 栈顶元素。
     */
    public int peek() {
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有元素");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]的值为 %d \n", i, stack[i]);
        }
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
