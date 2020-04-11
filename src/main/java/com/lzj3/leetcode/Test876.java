package com.lzj3.leetcode;

/**
 * 求链表的中间节点。
 * 使用快慢指针来做。奇数：中间。偶数，后面那个。
 *
 * @Author Sakura
 * @Date 2020/4/11 18:16
 */
public class Test876 {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
