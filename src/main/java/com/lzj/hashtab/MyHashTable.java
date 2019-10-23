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
            System.out.println("delete 删除");
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
                case "find":
                    System.out.println("输入要查找的id");
                    int queryId = scanner.nextInt();
                    hashTab.findEmpById(queryId);
                    break;
                case "delete":
                    System.out.println("输入要删除的emp id");
                    int delId = scanner.nextInt();
                    hashTab.deleteById(delId);
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("goodbye");
                    break;
                default:
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

    // 根据 id 找到对应的 emp。
    public void findEmpById(int id) {
        int index = hashFun(id);
        Emp emp = arr[index].findEmpById(id);
        if (emp == null) {
            System.out.println("未找到");
        } else {
            System.out.printf("在第 %d 条链表找到id为 %d 的 emp\n", index + 1, id);
        }
    }

    // 根据id删除对应的emp
    public void deleteById(int id) {
        int index = hashFun(id);
        EmpLinkedList empLinkedList = arr[index];
        empLinkedList.deleteById(id);
    }
}

/**
 * 链表
 * <p>
 * 链表有不存放数据的头节点，但是头节点都在数组里。
 * 这里的head写法是按照没有存放数据的头节点来写的。
 */
class EmpLinkedList {
    Emp head;

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

    /**
     * 根据 id 查找 Emp。
     *
     * @param id Emp的id
     * @return Emp
     */
    public Emp findEmpById(int id) {
        Emp temp = head;
        if (temp == null) {
            return null;
        }
        while (true) {
            if (temp.id == id) { // 根据id找到emp。
                break;
            }
            if (temp.next == null) { // 未找到emp。
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 根据 id 删除 emp。
     * <p>
     * 练习单链表的删除。
     *
     * @param id emp的id。
     */
    public void deleteById(int id) {
        // 构造一个头节点，next指向原来的链表。
        Emp emp = new Emp(-1, "");
        emp.next = head;
        Emp temp = emp;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false; // 标识是否找到待删除的节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到id为 %d 的节点", id);
        }
        // 这句话很重要。意味着将修改后的链表放回去。
        // 如果没有，那么对链表的改动将不会生效。
        head = emp.next;
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
