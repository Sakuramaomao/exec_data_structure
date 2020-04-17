package com.lzj3.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并区间
 *
 * @Author Sakura
 * @Date 2020/4/13 15:58
 */
public class Test56 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {9, 10}};
        merge(arr);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
