package com.lzj.tree;

/**
 * 二叉树。前中后序遍历。递归实现。
 * <p>
 * 二叉树的遍历核心是父节点，所有遍历方式都是从父节点开始，递归。
 *
 * @Author Sakura
 * @Date 2019/10/25 8:10
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 测试一把二叉树。
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "关胜");
        root.left = node1;
        root.right = node2;
        node2.left = node4;
        node2.right = node3;

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.midOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

class BinaryTree {
    private HeroNode root; // 二叉树根节点。

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前
    public void preOrder() {
        if (root == null) {
            System.out.println("空树");
        }
        root.preOrder();
    }

    // 中
    public void midOrder() {
        if (root == null) {
            System.out.println("空树");
        }
        root.midOrder();
    }

    // 后
    public void postOrder() {
        if (root == null) {
            System.out.println("空树");
        }
        root.postOrder();
    }

}

// 节点类
class HeroNode {
    int id;
    String name;
    HeroNode left;
    HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 主要是看父节点的输出顺序，父节点先输出，前。父节点第二输出，中。父节点第三输出，后。
    // 前序遍历。写之前假定调用preOrder方法的对象是父节点。
    public void preOrder() {
        System.out.println(this); // 先输出父节点
        if (this.left != null) {
            this.left.preOrder(); // 如果父节点左边非空，则继续左子树递归中序遍历。
        }
        if (this.right != null) {
            this.right.preOrder(); // 节点非空，继续右子树递归中序遍历。
        }
    }

    // 中序遍历，同理。
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this); // 第二输出父节点。
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this); // 第三输出父节点。
    }

}
