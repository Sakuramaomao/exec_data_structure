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
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "鲁智深", "和尚");
        HeroNode heroNode4 = new HeroNode(4, "武松", "呵呵呵");
        HeroNode heroNode5 = new HeroNode(4, "武松", "呵呵呵");
        HeroNode heroNode6 = new HeroNode(5, "武松", "呵呵呵");
        HeroNode heroNode7 = new HeroNode(1, "武松", "呵呵呵");



        // 测试一把无序添加节点。
        //singleLinkedList.add(heroNode1);
        //singleLinkedList.add(heroNode3);
        //singleLinkedList.add(heroNode2);
        //singleLinkedList.add(heroNode4);

        singleLinkedList2.addOrdered(heroNode5);
        singleLinkedList2.addOrdered(heroNode6);
        singleLinkedList2.addOrdered(heroNode7);

        // 测试一把有序添加节点。
        singleLinkedList.addOrdered(heroNode1);
        singleLinkedList.addOrdered(heroNode4);
        singleLinkedList.addOrdered(heroNode2);
        singleLinkedList.addOrdered(heroNode3);

        // 测试一把修改节点。
        //HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        //singleLinkedList.update(newHeroNode);

        // 测试一把删除节点。
        //singleLinkedList.delete(1);
        //singleLinkedList.delete(4);
        //singleLinkedList.delete(2);
        //singleLinkedList.delete(3);

        // 测试一把获取有效节点个数。
        //int length = singleLinkedList.length();
        //System.out.println("有效节点的个数：" + length);
        //singleLinkedList.delete(1);
        //int length2 = singleLinkedList.length();
        //System.out.println("有效节点的个数：" + length2);

        // 测试一把查找倒数第index个节点。（新浪面试题）
        //HeroNode lastIndexNode = singleLinkedList.lastIndexOf(1);
        //System.out.println("倒数:" + lastIndexNode.toString());

        // 测试一把单链表的反转。（腾讯面试题）
        //System.out.println("反转前：");
        //singleLinkedList.list();
        //singleLinkedList.reverse();
        //System.out.println("反转后：");

        // 测试一把单链表的逆序输出。（百度面试题）
        //System.out.println("正序打印：");
        //singleLinkedList.list();
        //System.out.println("逆序打印");
        //singleLinkedList.reverseList();

        // 测试一把课后作业。
        System.out.println("第一个有序链表为：");
        singleLinkedList.list();
        System.out.println("第二个有序链表为：");
        singleLinkedList2.list();
        System.out.println("合并后的有序链表为：");
        HeroNode head = SingleLinkedList.combineOrdered(singleLinkedList.getHead(), singleLinkedList2.getHead());
        SingleLinkedList.listWithHead(head);
    }
}
