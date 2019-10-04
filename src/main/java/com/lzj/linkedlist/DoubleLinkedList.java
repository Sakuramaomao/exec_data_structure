package com.lzj.linkedlist;

/**
 * 双向链表（带头节点）。
 *
 * @Author Sakura
 * @Date 2019/10/4 10:38
 */
public class DoubleLinkedList {
    // 先初始化一个头节点，头节点不要动，也不存放具体数据。
    private HeroNode2 head = new HeroNode2(0, null, null);

    /**
     * 有顺序的添加。
     * <p>
     * 注意：
     * 按照升序的方式添加。
     * 思路：
     * 找到待添加位置的前一个节点。这样做比较方便。
     *
     * @param heroNode 待添加的节点。
     */
    public void addOrdered(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
            heroNode.pre = temp; // 将新节点添加到双向链表中，总共需要连接四条线。
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 双向链表的节点删除
     * <p>
     * 注意：
     * 和单链表的删除不一样，不需要找到待删除节点的前一个节点，
     * 双向链表可以实现节点的自我删除。
     * 因此，直接找到要删除的节点即可。
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode2 temp = head.next;
        boolean flag = false; // 是否找到该节点。
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) { // 未找到节点。
                break;
            }
            if (temp.no == no) { // 找到节点。
                flag = true;
                break;
            }
            temp = temp.next;  // 继续遍历。
        }

        if (flag) { // 删除节点
            temp.pre.next = temp.next; // temp的前一个节点指向temp的后一个节点。
            if (temp.next != null) { // 这里是为了防止待删除的节点为链表的最后一个节点，而出现NPE。
                temp.next.pre = temp.pre; // temp的后一个节点指向temp的前一个节点。
            }
        } else {
            System.out.printf("未找到id%d的节点", no);
        }
    }

    /**
     * 双向链表的修改。no不能修改，要按照no来查找，只有name和和nickname才能修改。
     * 和单链表的修改没有区别。
     *
     * @param newHeroNode 待修改的节点。
     */
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head;
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

    /**
     * 直接添加节点至双向链表的尾部。
     *
     * @param heroNode 待添加节点。
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            // 单向链表的尾部标识为next域为null。所以要遍历找到尾节点再添加。
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode; // temp指向新节点。
        heroNode.pre = temp; // 新节点指向temp节点，完成添加。
    }

    /**
     * 遍历和单链表没有区别，在一个方向上遍历即可。
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
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
 * 水浒英雄的双向节点描述。
 */
class HeroNode2 {
    int no;  // 数据域
    String heroName;
    String heroNickName;

    HeroNode2 next; // 指针域，用来指向下一个节点。
    HeroNode2 pre; // 指针域，用来指向前一个节点。

    HeroNode2(int no, String heroName, String heroNickName) {
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