package com.lzj.stack;

/**
 * 使用单链表模拟栈（待头节点）。
 * <p>
 * 注意：
 * 单链表模拟栈，使用头插法比较方便。
 * <p>
 * 和数组模拟栈相比，单链表模拟的栈容量不受限制。
 * 而且速度上和数组相当，所以更推荐使用单链表头插法来模拟栈。
 *
 * @Author Sakura
 * @Date 2019/10/5 12:19
 */
public class LinkedListStack {
    private ListNode head = new ListNode(0); // 头节点。
    private ListNode top = head.next; // 栈顶节点。

    /**
     * 入栈
     *
     * @param data 待入栈的元素。
     */
    public void push(int data) {
        ListNode node = new ListNode(data);
        node.next = head.next; // 头插。
        head.next = node;
        top = node; // 栈顶上升一位。
    }

    /**
     * 出栈
     *
     * @return 栈顶元素。
     */
    public int pop() {
        if (top == null) {
            throw new RuntimeException("栈空，没有元素");
        }
        ListNode temp = top; // 头删。
        head.next = top.next;
        top = top.next; // 栈顶后移一位。
        return temp.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void list() {
        if (top == null) {
            System.out.println("栈空，没有元素");
            return;
        }
        ListNode temp = top;
        while (true) {
            System.out.printf("linkedListStack的值为 %d \n", temp.getData());
            if (temp.next == null) { // 遍历到最后一个节点，退出循环。
                break;
            }
            temp = temp.next;
        }
    }
}

// 描述单链表节点的类
class ListNode {
    private int data; // 数据域。
    ListNode next; // 指针域，指向下一个节点。

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
