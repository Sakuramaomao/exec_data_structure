package com.lzj.linkedlist;

/**
 * 单向链表（带头节点）。
 * <p>
 * 新元素将在单向链表的尾部插入，未排序。
 * SingleLinkedList用来管理HeroNode。
 *
 * @Author Sakura
 * @Date 2019/9/24 7:49
 */
public class SingleLinkedList {
    // 先初始化一个头节点，头节点不要动，也不存放具体数据。
    private HeroNode head = new HeroNode(0, null, null);

    // 添加节点至链表尾部。
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            // 单向链表的尾部标识为next域为null。所以要遍历找到尾节点再添加。
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }
}

/**
 * 水浒英雄的节点描述。
 */
class HeroNode {
    private int no;  // 数据域
    private String heroName;
    private String heroNickName;

    public HeroNode next; // 指针域，用来指向下一个节点。

    public HeroNode(int no, String heroName, String heroNickName) {
        this.no = no;
        this.heroName = heroName;
        this.heroNickName = heroNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", heroName='" + heroName + '\'' +
                ", heroNickName='" + heroNickName + '\'' +
                '}';
    }
}
