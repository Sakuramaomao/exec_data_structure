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
        // 构建二叉树
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

        // 测试一把二叉树遍历。
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.midOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();

        System.out.println("===============");
        // 测试一把查找
        System.out.println("前序查找");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到id为 %d 的英雄，名称为 %s \n", resNode.id, resNode.name);
        } else {
            System.out.println("没有找到");
        }

        System.out.println("中序查找");
        HeroNode resNode2 = binaryTree.midOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到id为 %d 的英雄，名称为 %s \n", resNode2.id, resNode2.name);
        } else {
            System.out.println("没有找到");
        }

        System.out.println("后序查找");
        HeroNode resNode3 = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到id为 %d 的英雄，名称为 %s \n", resNode3.id, resNode3.name);
        } else {
            System.out.println("没有找到");
        }


    }
}

class BinaryTree {
    private HeroNode root; // 二叉树根节点。

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.id == no) { // 这里要先对root本身进行判断。
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树");
        }
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

    // 前 查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中 查找
    public HeroNode midOrderSearch(int no) {
        if (root != null) {
            return root.midOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后 查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
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

    // 删除指定节点，如果是叶子节点，直接删除；如果是父节点，删除子树。
    // 类似单链表的删除，必须知道上一个节点才能删除当前节点。
    public void delNode(int no) {
        if (this.left != null && this.left.id == no) { // 对比当前节点的左节点。
            this.left = null;
            return;
        }

        if (this.right != null && this.right.id == no) { // 对比当前节点的右节点。
            this.right = null;
            return;
        }

        // 如果都不是，则要开始递归。
        if (this.left != null) {
            this.left.delNode(no); // 先向左边递归
        }
        if (this.right != null) {
            this.right.delNode(no); // 再向右边递归
        }
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

    /**
     * 前序遍历查找
     *
     * @param no 查找no。
     * @return 如果找到，返回HeroNode。
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("查找一次");
        if (this.id == no) { // 如果这个父节点满足，返回；否则，向左节点寻找。
            return this;
        }

        HeroNode heroNode = null;
        if (this.left != null) { // 如果左节点存在，则递归。（递归时，会将其看做另一个父节点的。）
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { // 如果从左边找到，则返回；否则，向右节点寻找。
            return heroNode;
        }

        if (this.right != null) { // 如果右节点存在，则递归。（同样，递归时，会将其看做另一个父节点的。）
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode; // 无论找到还是未找到，都直接返回了。
    }

    /**
     * 中序遍历查找。
     *
     * @param no 查找no。
     * @return 如果找到，返回HeroNode。
     */
    public HeroNode midOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) { // 如果左节点存在，则递归。（从最左边的叶子节点开始判断。）
            heroNode = this.left.midOrderSearch(no);
        }
        if (heroNode != null) { // 如果左边找到，则返回。否则，向父节点找。
            return heroNode;
        }

        System.out.println("查找一次");
        if (this.id == no) { // 如果这个父节点满足，则返回，否则，向右边找。（最左边或者最右边的叶子节点本身可以看做是父节点）
            return this;
        }

        if (this.right != null) { // 如果右节点存在，则递归。（从最右边的叶子节点开始判断。）
            heroNode = this.right.midOrderSearch(no);
        }
        return heroNode; // 无论找到还是未找到，都要返回了。
    }

    /**
     * 后序遍历查找。
     *
     * @param no 查找no。
     * @return 如果找到，返回HeroNode。
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) { // 如果左节点存在，则递归。（从最左边的叶子节点开始判断。）
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode != null) { // 如果左边找到，返回，否则，向右边找。
            return heroNode;
        }

        if (this.right != null) { // 如果右节点存在，则递归。
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null) { // 如果右边找到，则返回，否则，向父节点找。
            return heroNode;
        }

        System.out.println("查找一次");
        if (this.id == no) { // 如果父节点找到，则返回，否则，返回null。
            return this;
        } else {
            return null;
        }
    }
}
