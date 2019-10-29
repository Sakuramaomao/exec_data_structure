package com.lzj.tree;

/**
 * 顺序存储二叉树。
 * <p>
 * 将一个一维数组按照前中后序的方式遍历。实现数组和二叉树间的转换。
 *
 * @Author Sakura
 * @Date 2019/10/29 7:34
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.println("前序遍历");
        arrayBinaryTree.preOrder(0);
        System.out.println("中序遍历");
        arrayBinaryTree.midOrder(0);
        System.out.println("后序遍历");
        arrayBinaryTree.postOrder(0);
    }
}

// 编写一个顺序存储二叉树，实现其遍历。
class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历。
     * <p>
     * 第index个元素，左节点下标为 2*index + 1，右节点下标为2*index + 2。父节点为(n - 1)/2
     *
     * @param index 数组中第n个元素。 一般从0开始，表示根节点。
     */
    public void preOrder(int index) {
        // 先判断一把
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        System.out.println(arr[index]);
        if ((2 * index + 1) < arr.length) { //  防止越界
            preOrder(2 * index + 1); // 先向左边递归。
        }
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2); // 再向右边递归。
        }
    }

    // 中序遍历
    public void midOrder(int index) {
        // 先判断一把
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if ((2 * index + 1) < arr.length) { //  防止越界
            midOrder(2 * index + 1); // 先向左边递归。
        }
        System.out.println(arr[index]);
        if ((2 * index + 2) < arr.length) {
            midOrder(2 * index + 2); // 再向右边递归。
        }
    }

    // 后序遍历
    public void postOrder(int index) {
        // 先判断一把
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if ((2 * index + 1) < arr.length) { //  防止越界
            postOrder(2 * index + 1); // 先向左边递归。
        }
        if ((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2); // 再向右边递归。
        }
        System.out.println(arr[index]);
    }
}
