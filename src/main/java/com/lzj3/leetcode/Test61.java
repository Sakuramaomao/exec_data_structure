package com.lzj3.leetcode;

/**
 * 旋转链表。
 * 1、遍历找到尾节点，顺便统计链表长度，并形成循环单链表。
 * 2、计算跳跃次数，尾节点和头节点同时跳跃。
 * 3、将环断开，返回头节点所在的位置。
 *
 * @Author Sakura
 * @Date 2020/4/11 16:48
 */
public class Test61 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        for (int i = 0; i < nums.length; i++) {
            ListNode tmp = head;
            ListNode node = new ListNode(nums[i]);
            while (true) {
                if (tmp.next == null) {
                    break;
                }
                tmp = tmp.next;
            }
            tmp.next = node;
        }

        ListNode res = rotateRight(head.next, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode tail = head;
        // 遍历并成环。
        int len = 0;
        while (true) {
            len++;
            if (tail.next == null) {
                tail.next = head;
                break;
            }
            tail = tail.next;
        }

        ListNode newHead = head;
        for (int i = 0; i < (len - k % len); i++) {
            newHead = newHead.next;
            tail = tail.next;
        }
        tail.next = null;

        return newHead;
    }
}
