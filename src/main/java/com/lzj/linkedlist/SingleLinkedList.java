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

    // 直接添加节点至链表尾部。
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            // 单向链表的尾部标识为next域为null。所以要遍历找到尾节点再添加。
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 有顺序的插入
    public void addOrdered(HeroNode heroNode) {
        // 因为头节点不能动，所以仍然通过一个辅助指针（变量）来帮助找到添加的位置。
        // 因为单链表，需要找的是添加位置的前一个节点，否则添加不了。
        HeroNode temp = head;
        boolean flag = false; // 标识链表中是否已经存在相同编号的节点。
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break; // 使用temp的后一个节点进行比较，那么找到的temp就是待插入位置了，在temp的后面插入。
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("英雄已存在，编号为%d", temp.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 单链表的修改。no不能修改，要按照no来查找，只有name和和nickname才能修改。
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        boolean flag = false; //是否找到。
        while (true) {
            if (temp.next == null) {
                System.out.println("没有找到");
                return;
            }

            if (temp.no == newHeroNode.no) { // 根据no找到要修改的节点。
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.heroName = newHeroNode.heroName;
            temp.heroNickName = newHeroNode.heroNickName;
        } else {
            System.out.println("没有找到");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            System.out.println(temp.toString());
            if (temp.next == null) {
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
    int no;  // 数据域
    String heroName;
    String heroNickName;

    HeroNode next; // 指针域，用来指向下一个节点。

    HeroNode(int no, String heroName, String heroNickName) {
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
