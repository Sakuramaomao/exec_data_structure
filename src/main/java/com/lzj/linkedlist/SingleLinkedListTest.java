package com.lzj.linkedlist;

/**
 * 单链表测试。
 *
 * @Author Sakura
 * @Date 2019/9/26 8:08
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "鲁智深", "和尚");
        HeroNode heroNode4 = new HeroNode(4, "武松", "呵呵呵");

        // 测试一把无序添加节点。
        //singleLinkedList.add(heroNode1);
        //singleLinkedList.add(heroNode2);
        //singleLinkedList.add(heroNode3);
        //singleLinkedList.add(heroNode4);

        // 测试一把有序添加节点。
        singleLinkedList.addOrdered(heroNode1);
        singleLinkedList.addOrdered(heroNode4);
        singleLinkedList.addOrdered(heroNode2);
        singleLinkedList.addOrdered(heroNode3);

        // 测试一把修改节点。
        //HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        //singleLinkedList.update(newHeroNode);

        // 测试一把删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);

        singleLinkedList.list();
    }
}
