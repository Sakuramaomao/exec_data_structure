package com.lzj.binarysorttree;

/**
 * 二叉排序树-BST
 *
 * @Author Sakura
 * @Date 2019/11/6 22:25
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            binarySortTree.add(node);
        }
        System.out.println("原树");
        binarySortTree.midOrder();

        // 测试一把叶子节点的删除
        binarySortTree.delete(2);
        System.out.println("删除后的树");
        binarySortTree.midOrder();
    }
}

class BinarySortTree {
    private Node root;

    // 删除节点
    public void delete(int val) {
        if (root == null) { // 如果是空树，直接返回。
            return;
        } else {
            Node targetNode = search(val); // 找到这个节点。
            if (targetNode == null) { // 如果没找到
                return;
            }
            // 如果找到。
            // 先判断找到的是否为root节点本身。即树只有一个节点的情况。
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 找到targetNode的父节点
            Node targetParent = searchParent(val);
            // 如果要删除节点时叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断要删除的是父节点的左子节点还是右子节点。
                if (targetParent.left != null && targetParent.left.value == val) {
                    targetParent.left = null;  // 删除左边。
                }
                if (targetParent.right != null && targetParent.right.value == val) {
                    targetParent.right = null; // 删除右边。
                }
            }
        }
    }

    // 查找要删除的节点
    public Node search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    // 查找要删除节点的父节点
    public Node searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
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
     * 查找要删除的节点。
     *
     * @param val 希望查找的值。
     * @return 如果找到，返回Node；否则，返回null。
     */
    public Node search(int val) {
        if (this.value == val) {
            return this;
        } else if (val < this.value) { // 如果比当前节点值小，就向左寻找。
            if (this.left == null) {
                return null;
            }
            return this.left.search(val);
        } else { // 如果大于等于当前节点值，就都向右寻找。
            if (this.right == null) {
                return null;
            }
            return this.right.search(val);
        }
    }

    /**
     * 查找要删除节点的父节点。
     *
     * @param value 希望查找的值。
     * @return 如果找到，返回父节点node；否则，返回null。
     */
    public Node searchParent(int value) {
        // 如果当前节点就是要删除的节点的父节点，就返回。
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点不为空。
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) { // 如果查找的值大于等于当前节点的值。
                return this.right.searchParent(value);
            } else {
                return null; // 如果都没有找到，直接返回null。
            }
        }
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
