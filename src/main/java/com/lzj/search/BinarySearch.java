package com.lzj.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找算法。
 *
 * @Author Sakura
 * @Date 2019/10/20 10:57
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        // 测试一把基础写法。
        //int res = binarySearch(arr, 0, arr.length - 1, 10);
        //System.out.printf("待查找元素的索引为：%d \n", res);
        // 测试一把增强型写法。
        List<Integer> resultList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("待查找元素的索引集合为：" + resultList);
    }

    /**
     * 基础写法。使用递归。
     * <p>
     * 这种基础的写法，只能返回第一个被找到元素的索引。当数组中有多个相同元素时，无法满足。
     *
     * @param arr     有序数组，从小到大排列。
     * @param left    左边下标
     * @param right   右边下标
     * @param findVal 查找值
     * @return 如果找到，返回查找值的索引，如果没找到，返回 -1。
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) { // 如果未找到，返回 -1。
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { // 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else { // findVal == midVal, 说明已经找到，直接返回索引。
            return mid;
        }
    }

    /**
     * 小练习。
     * <p>
     * 对基础写法所实现的功能进行增强。将所有匹配到的查找值的索引都返回。
     * <p>
     * 思路：
     * 在基础写法上进行略微扩展即可。
     *
     * @param arr     有序数组，从小到大排列
     * @param left    左边下标
     * @param right   右边下标
     * @param findVal 查找值
     * @return 所有和查找值匹配的元素下标集合。
     */
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) { // 如果未找到，返回空集合。
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { // 向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else { // findVal == midVal, 说明已经找到。
            ArrayList<Integer> resultList = new ArrayList<>();
            // 先将找到的mid保存到集合中。
            resultList.add(mid);
            // 然后从mid开始继续向左和向右寻找。
            // 1、向左边寻找相同元素。
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) { // 退出
                    break;
                }
                resultList.add(temp);
                temp--;
            }
            // 向右边寻找。
            int temp2 = mid + 1;
            while (true) {
                if (temp2 > arr.length - 1 || arr[temp2] != findVal) { // 退出
                    break;
                }
                resultList.add(temp2);
                temp2++;
            }
            return resultList;
        }
    }
}
