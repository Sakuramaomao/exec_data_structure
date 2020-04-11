package com.lzj3.leetcode;

import java.util.HashSet;

/**
 * 判断链表中是否有环。
 *
 * @Author Sakura
 * @Date 2020/4/11 17:36
 */
public class Test141 {
    public static void main(String[] args) {

    }

    // 普通解法
    public static boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            hashSet.add(temp);
            if (hashSet.contains(temp.next)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // 双指针解法。快指针一次走两步，慢指针一次走一步。如果有环，那肯定会追上的。如果没有，快指针会先到终点。
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (true) {
            if (slow == fast) break;
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
