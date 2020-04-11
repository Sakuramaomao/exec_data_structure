package com.lzj3.leetcode;

/**
 * 快乐数。
 * 使用快慢指针。
 *
 * @Author Sakura
 * @Date 2020/4/11 18:03
 */
public class Test202 {
    public static void main(String[] args) {

    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);
            if (fast == 1) return true;
            if (slow == fast) break;
        }
        return false;
    }

    public static int square(int n) {
        int sum = 0;
        while (true) {
            if (n == 0) break;
            int bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }
}
