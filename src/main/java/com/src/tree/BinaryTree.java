package com.src.tree;

import java.util.Stack;

/**
 * 作业；
 *      手写一个二叉树API，具有以下功能：
 *      1、构建一个特定的二叉树。
 *      2、获取树的深度（或高度），节点数量。
 *      3、对树进行前中后序遍历（迭代方式实现）。
 *      4、对树进行前中后序遍历（非迭代方式，利用栈的机制实现）。
 * @Author Sakura
 * @Date 2019/2/27 21:23
 */
public class BinaryTree {
    private TreeNode root = null; // 定义一个空的根节点。

    /**
     * BinaryTree初始就会有一个默认的根节点存在。
     */
    public BinaryTree() {
        root = new TreeNode<String>(1, "A"); // 初始化根节点。
    }

    /**
     * 1、构建一个特定的二叉树。
     * 模型如下：
     *          A
     *     B        C
     *  D    E         F
     */
    public void createBinaryTree() {
        TreeNode<String> B = new TreeNode<String>(2, "B");
        TreeNode<String> C = new TreeNode<String>(3, "C");
        TreeNode<String> D = new TreeNode<String>(4, "D");
        TreeNode<String> E = new TreeNode<String>(5, "E");
        TreeNode<String> F = new TreeNode<String>(6, "F");
        root.setlChild(B);
        root.setrChild(C);
        B.setlChild(D);
        B.setrChild(E);
        C.setrChild(F);
    }

    // TODO 可以接收一个数组，然后按照指定的遍历方式将数组解析为一个二叉树。
    public void createBinaryTree(Object[] args) {}

    /**
     * 2、使用迭代的方式计算一个二叉树的深度。
     * @param node 一个根节点。
     * @return int 二叉树的深度。
     */
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.getlChild());
            int j = getHeight(node.getrChild());
            return (i>j) ? i + 1 : j + 1;
        }
    }

    /**
     * 3、使用迭代的方式计算一个二叉树中节点的个数。
     * @param node 一个根节点。
     * @return int 二叉树中节点的个数。
     */
    public int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.getlChild()) + getSize(node.getrChild());
        }
    }

    /**
     * 4、使用迭代的方式计算一个二叉树的前序遍历结果。
     * @param node 一个根节点。
     */
    public void preOrderTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println("节点: " + node.getData());
            preOrderTree(node.getlChild());
            preOrderTree(node.getrChild());
        }
    }

    /**
     * 5、使用迭代的方式计算一个二叉树的中序遍历结果。
     * @param node 一个根节点。
     */
    public void midOrderTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOrderTree(node.getlChild());
            System.out.println("节点：" + node.getData());
            midOrderTree(node.getrChild());
        }
    }

    /**
     * 6、使用迭代方式计算一个二叉树的后续遍历结果。
     * @param node 一个根节点。
     */
    public void postOrderTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            postOrderTree(node.getlChild());
            postOrderTree(node.getrChild());
            System.out.println("节点：" + node.getData());
        }
    }

    /**
     * 7、使用非迭代的方式计算一个二叉树的前序遍历结果。
     * @param node 一个根节点。
     */
    public void nonPerOrderTree(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop(); // 出栈和入栈
            System.out.println("节点：" + treeNode.getData());
            if (treeNode.getrChild() != null) {
                stack.push(treeNode.getrChild()); // 压入子节点
            }
            if (treeNode.getlChild() != null) {
                stack.push(treeNode.getlChild()); // 压入子节点
            }
        }
    }

    /**
     * 8、使用非迭代方式计算一个二叉树的中序遍历结果。
     * @param node 一个根节点。
     */
    public void nonMidOrderTree(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            // TODO 使用非迭代的方式实现二叉树的中序遍历。
           //TreeNode lnode = node.getlChild();
           // while (lnode != null) {
           //     stack.push(lnode);
           // }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        int height = binaryTree.getHeight(binaryTree.root);
        System.out.println("tree height: " + height);
        int size = binaryTree.getSize(binaryTree.root);
        System.out.println("tree size: " + size);
        System.out.println("------前序遍历结果------");
        binaryTree.preOrderTree(binaryTree.root);
        System.out.println("------中序遍历结果------");
        binaryTree.midOrderTree(binaryTree.root);
        System.out.println("------后序遍历结果------");
        binaryTree.postOrderTree(binaryTree.root);
        System.out.println("------非迭代方式前序遍历结果-----");
        binaryTree.nonPerOrderTree(binaryTree.root);
        System.out.println("------非迭代方式中序遍历结果-----");
        binaryTree.nonMidOrderTree(binaryTree.root);
        //System.out.println("------非迭代方式后序遍历结果-----");
    }

}
