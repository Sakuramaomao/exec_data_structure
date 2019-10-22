package com.lzj.hashtab;

import java.util.Scanner;

/**
 * 自定义实现哈希表。是数组 + 链表形式的哈希表。
 * <p>
 * 源于一个谷歌算法题。
 *
 * @Author Sakura
 * @Date 2019/10/21 22:44
 */
public class MyHashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        // 写一个菜单，方便测试。
        String key = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add 添加");
            System.out.println("list 查看");
            System.out.println("exit 退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("goodbye");
                    break;
            }
        }
    }
}

/**
 * 哈希表
 * <p>
 * 对哈希表的操作，虽然是在这里调用的，但是实际的add和list是在链表类中实现的。
 */
class HashTab {
    // 属性
    private EmpLinkedList[] arr; // 散列数组
    private int size; // 数组容量

    // 构造
    public HashTab(int size) {
        this.size = size;
        arr = new EmpLinkedList[size];
        // 这里有个坑，不要忘了将链表都初始化，否则会NPE。
        // 其实链表的头节点都在数组里。
        for (int i = 0; i < size; i++) {
            arr[i] = new EmpLinkedList();
        }
    }

    // 散列函数
    private int hashFun(int id) {
        return id % size;
    }

    // 哈希表的操作
    public void add(Emp emp) {
        int index = hashFun(emp.id); // 使用散列函数确定要在哪条链表中添加
        arr[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            arr[i].list(i);
        }
    }

    // TODO findEmpById

    // TODO updateEmpById

    // TODO deleteEmpById
}

/**
 * 链表
 * <p>
 * 链表有不存放数据的头节点，但是头节点都在数组里。
 * 这里的head写法是按照没有存放数据的头节点来写的。
 */
class EmpLinkedList {
    private Emp head;

    // 添加emp到链表
    public void add(Emp emp) {
        if (head == null) { // 无元素时，让head变为emp。
            head = emp;
            return;
        }
        Emp last = head;
        while (true) { // 有元素时，添加到最后一个节点的后面。
            if (head.next == null) {
                break;
            }
            last = head.next;
        }
        last.next = emp;
    }

    /**
     * 遍历链表
     *
     * @param i 第 i 条链表
     */
    public void list(int i) {
        if (head == null) {
            System.out.printf("第 %d 条链表为空 \n", i + 1);
            return;
        }
        Emp temp = head;
        System.out.printf("第 %d 条链表数据为", i + 1);
        while (true) {
            System.out.printf(" ==> id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

/**
 * 员工
 */
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
