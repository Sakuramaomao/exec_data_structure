package com.lzj.linkedlist;

/**
 * 双向链表的测试。
 *
 * @Author Sakura
 * @Date 2019/10/4 11:15
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "鲁智深", "和尚");
        HeroNode2 heroNode5 = new HeroNode2(5, "武松", "行者");
        HeroNode2 heroNode6 = new HeroNode2(6, "吴用", "智多星");

        System.out.println("添加测试：");
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode5);
        doubleLinkedList.add(heroNode6);

        doubleLinkedList.list();

        System.out.println("更新测试：");
        doubleLinkedList.update(new HeroNode2(3, "鲁智深", "花和尚"));
        doubleLinkedList.list();

        System.out.println("删除测试：");
        doubleLinkedList.delete(5);
        doubleLinkedList.list();

        System.out.println("测试有序添加");
        HeroNode2 heroNode4 = new HeroNode2(4, "吴用4", "智多星");
        doubleLinkedList.addOrdered(heroNode4);
        doubleLinkedList.list();
    }
}
