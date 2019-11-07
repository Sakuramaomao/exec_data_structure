package com.lzj.binarysorttree;

/**
 * 二叉排序树-BST
 *
 * @Author Sakura
 * @Date 2019/11/6 22:25
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            binarySortTree.add(node);
        }
        binarySortTree.midOrder();
    }
}

class BinarySortTree {
    private Node root;

    /**
     * 查找要删除的节点。
     *
     * @param value 希望查找的值。
     * @return 如果找到，返回Node；否则，返回null。
     */
    public Node search(int value) {
        // TODO
        return null;
    }

    /**
     * 查找要删除节点的父节点。
     *
     * @param value 希望查找的值。
     * @return 如果找到，返回父节点node；否则，返回null。
     */
    public Node searchParent(int value) {
        // TODO
        return null;
    }

    // 添加节点到二叉排序树中。
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("树为空");
        }
    }
}

// 定义二叉排序树的节点。
class Node {
    int value; // 节点数值。
    Node left; // 左子节点。
    Node right; // 右子节点。

    public Node(int value) {
        this.value = value;
    }

    /**
     * 添加节点。递归方式添加。
     *
     * @param node 待添加的节点。
     */
    public void add(Node node) {
        if (node.value < this.value) { // node比当前节点小，应该挂在左边。
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else { // 当node大于等于当前节点时，都挂在右边。
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
