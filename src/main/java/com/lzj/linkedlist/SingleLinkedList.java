package com.lzj.linkedlist;

import java.util.Stack;

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
                break; // 使用temp的后一个节点进行比较，那么找到的temp后面就是待插入位置了。
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

    // 1、头节点不能动，使用辅助变量来帮助完成。
    // 2、必须要找到待删除节点的前一个节点才能删除，如果直接找到待删除节点，是无法删除这个节点的。
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 是否找到该节点。
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到id%d的节点", no);
        }
    }

    /**
     * 获取链表中有效节点的个数。（带有头节点的将不统计头节点）
     * <p>
     * //* @param head 链表的头节点。
     *
     * @return 有效节点的个数。
     */
    public int length() {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next; // 这里体现了不统计头节点。
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 第一题：获取单链表中倒数第index个节点。（新浪面试题）
     * <p>
     * 1、获取单链表长度length。
     * 2、遍历(length - index)次找到节点位置。
     *
     * @param index 倒数的节点位置。
     * @return 节点。
     * @throws NullPointerException 如果 index 非法。
     */
    public HeroNode lastIndexOf(int index) {
        if (head.next == null) {
            return null; // 如果单链表为空，那么返回null。
        }
        int length = this.length();
        if (index <= 0 || index > length) {
            return null;
        }

        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;  // 遍历找到倒数第index个节点。
        }
        return temp;
    }

    /**
     * 第二题：单链表反转。（腾讯面试题）
     * <p>
     * 思路：
     * 1、新建一个单链表，只有头节点。
     * 2、从旧链表中将节点一个个遍历并摘下，拼接到新链表的头部。
     * <p>
     * 其中难点在于如何永远在单链表的头部插入节点。
     */
    public void reverse() {
        if (head.next == null || head.next.next == null) { // 如果单链表为空或者只有一个节点，则不需要反转。
            return;
        }
        HeroNode reversedHead = new HeroNode(0, "", ""); // 新链表头节点。
        HeroNode cur = head.next;
        HeroNode next = null; // 需要用一个临时变量next来保存cur的下一个节点。
        while (cur != null) {
            next = cur.next;

            cur.next = reversedHead.next; // 将cur插入到新链表的第一个节点位置。即永远在单链表的头部插入节点的小练习。
            reversedHead.next = cur;

            cur = next;
        }
        head.next = reversedHead.next; // 将反转后的链表重新赋值给head。
    }

    /**
     * 第三题：逆序遍历整个链表。（百度面试题）
     * <p>
     * 思路：
     * 可以利用栈的后入先出特性来逆序输出。
     * （不能通过反转链表后再输出，这样会破坏原来的数据结构，不推荐。）
     */
    public void reverseList() {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack();
        while (cur != null) {
            stack.push(cur); // 入栈
            cur = cur.next;
        }
        while (stack.size() > 0) {  // 出栈
            HeroNode hero = stack.pop();
            System.out.println(hero.toString());
        }
    }

    // 遍历：通过一个辅助变量temp，帮助遍历整个链表。
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

    public static void listWithHead(HeroNode head) {
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

    /**
     * 作业：合并两个有序的单链表，合并之后的链表依然有序。
     * <p>
     * 思路：
     * 建立一个空链表，依次遍历摘取两个链表的每个节点，有序的放入新的链表中。
     *
     * @param h1 第一个有序单链表的头节点。
     * @param h2 第二个有序单链表的头节点。
     * @return 合并后的单链表，合并后依然有序。
     */
    public static HeroNode combineOrdered(HeroNode h1, HeroNode h2) {
        HeroNode temp1 = h1.next;
        HeroNode temp2 = h2.next;
        if (temp1 == null) return h2;
        if (temp2 == null) return h1;

        HeroNode comOrderHead = new HeroNode(0, "", "");
        HeroNode tail = comOrderHead;
        while (true) {
            if (temp1 == null && temp2 == null) { // 当两个链表都遍历到最后时才会退出。
                break;
            }
            if (temp1 == null) { // 当其中一个链表结束时，直接将另一个全部添加到新链表中。
                tail.next = temp2;
                break;
            }
            if (temp2 == null) {
                tail.next = temp1;
                break;
            }

            if (temp1.no < temp2.no) {
                tail.next = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
        }
        return comOrderHead;
    }

    public HeroNode getHead() {
        return head;
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
