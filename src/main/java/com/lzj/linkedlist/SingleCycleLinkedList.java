package com.lzj.linkedlist;

/**
 * 单向循环链表。
 * <p>
 * 此类不通用，只是为了求解josephu问题。
 *
 * @Author Sakura
 * @Date 2019/10/4 16:46
 */
public class SingleCycleLinkedList {
    private Boy first = null; // 单向循环链表中的第一个节点。

    /**
     * 创建一个拥有num个小孩的单向循环链表。
     *
     * @param num 链表中小孩的个数。
     */
    public void create(int num) {
        if (num < 1) System.out.println("num的值有问题");

        Boy curBoy = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) { // 创建第一个小孩，并形成环状。
                first = new Boy(i);
                first.setNext(first);
                curBoy = first; // 让curBoy先指向first节点。
            } else { // 创建其他的小孩，并加入到环中。
                Boy boy = new Boy(i);
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; // curBoy指向新加入的节点。
            }
        }
    }

    /**
     * 小孩出圈。
     * <p>
     * 因为也是单向的，所以在删除节点时必须要知道待删除节点的前一个节点才能删除。
     * 所以引入helper临时指针来辅助。
     *
     * @param boyNum   小孩人数。
     * @param startNum 从第几个小孩开始数数。
     * @param countNum 数几下。
     */
    public void boyOut(int boyNum, int startNum, int countNum) {
        if (first == null || boyNum < 1 || startNum > countNum) {
            System.out.println("设置的参数不正确");
        }

        // 1、创建一个辅助指针helper，事先应该指向环形链表的最后一个节点。
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) { // 当只剩下一个节点时，退出循环。
                break;
            }

            // 2、小孩报数前，让helper和first同时移动 startNum - 1 次，找到第一个报数的小孩。
            for (int i = 0; i < startNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            // 3、开始报数，让helper和first同时移动 countNUm - 1 次，找到该出圈的小孩。
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext(); // 此时，first指向要出圈的小孩，helper为first的前一个节点。
            }
            System.out.printf("出圈的小孩id为 %d \n", first.getNo());

            // 4、让first往后移动一次，设置helper的next指向现在first的位置，原来first指向的小孩没有被引用，
            // 变为垃圾，使得小孩出圈。
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个出圈的小孩id为 %d \n", first.getNo()); // 输出最后一个节点。
    }

    // 打印单向循环链表。
    public void showBoy() {
        if (first == null) {
            System.out.println("单向循环链表为空");
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("当前小孩的id是 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) { // 当curBoy的指针域指向first时，说明遍历完成了，要退出。
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

// 单向循环链表中用来描述小孩节点的类。
class Boy {
    private int no; // 小孩编号。
    private Boy next; // 指针域，指向下一个小孩。

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }
}
