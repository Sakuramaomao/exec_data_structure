package com.lzj.linkedlist;

/**
 * 求解约瑟夫问题。
 *
 * @Author Sakura
 * @Date 2019/10/4 17:10
 */
public class Josephu {
    public static void main(String[] args) {
        SingleCycleLinkedList singleCycleLinkedList = new SingleCycleLinkedList();
        singleCycleLinkedList.create(5);
        singleCycleLinkedList.showBoy();
        System.out.println();
        System.out.println("小孩出圈的顺序：");
        singleCycleLinkedList.boyOut(5, 1, 2);
    }
}
