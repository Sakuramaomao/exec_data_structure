package com.lzj.avltree;

/**
 * 平衡二叉树--AVLTree
 *
 * @Author Sakura
 * @Date 2019/11/10 11:19
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {10, 12, 8, 9, 7, 6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("平衡二叉树为：");
        avlTree.midOrder();

        System.out.println("avl树高度为：" + avlTree.getRoot().height());
        System.out.println("root节点左子树高度为：" + avlTree.getRoot().leftHeight());
        System.out.println("root节点右子树高度为：" + avlTree.getRoot().rightHeight());
        System.out.println("root节点为：" + avlTree.getRoot());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
            // 如果要的删除节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断要删除的是父节点的左子节点还是右子节点。
                if (targetParent.left != null && targetParent.left.value == val) {
                    targetParent.left = null;  // 删除左边。
                }
                if (targetParent.right != null && targetParent.right.value == val) {
                    targetParent.right = null; // 删除右边。
                }
                // 如果要删除的节点是有两个子树的节点。
            } else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRigthMin(targetNode.right);
                targetNode.value = minVal;
            } else { // 如果要删除的节点是只有一个子树的节点。
                // 不想写了。。
            }
        }
    }

    /**
     * 1、返回的以node为根节点的二叉排序树的最小节点的值。
     * 2、删除此叶子节点。
     *
     * @param node 传入的节点（当做二叉排序树的根节点）。
     * @return 返回的以node为根节点的二叉排序树的最小节点的值。
     */
    public int delRigthMin(Node node) {
        Node temp = node; // 不对node直接改动，将其用临时变量存起来。
        while (temp.left != null) {
            temp = temp.left; // 因为是二叉排序树，一直找到左边的叶子节点，也就找到了最小节点。
        }
        // 这个temp就指向了最小节点。
        // 删除最小节点。
        delete(temp.value);
        return temp.value; // 返回此节点的值。
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

    // 添加节点到平衡二叉树中。
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

// 定义平衡二叉树的节点。
class Node {
    int value; // 节点数值。
    Node left; // 左子节点。
    Node right; // 右子节点。

    public Node(int value) {
        this.value = value;
    }

    /**
     * 右旋。
     * 步骤比较多，有些步骤是跟左旋相对应的。但是每一步都不复杂，一点点跟着思路写就行。
     * 主要就是当前节点和新节点之间的操作。
     */
    public void rightRotate() {
        // 用当前节点的值创建一个新节点。
        Node newNode = new Node(value);
        // 设置新节点的右节点为当前节点的右节点。
        newNode.right = this.right;
        // 设置新节点的左节点为当前节点左节点的右节点。
        newNode.left = this.left.right;
        // 设置当前节点的值为当前节点的左节点。
        this.value = this.left.value;
        // 设置当前节点的左节点为当前节点左节点的左节点。
        this.left = this.left.left;
        // 设置当前节点的右节点为新节点。
        this.right = newNode;
    }

    /**
     * 左旋。
     * 步骤比较多，但是每一步都不复杂，一点点跟着思路写就行。
     * 主要就是当前节点和新节点之间的操作。
     */
    public void leftRotate() {
        // 用当前节点的值创建一个新节点。
        Node newNode = new Node(this.value);
        // 设置新节点的左节点为当前节点的左节点。
        newNode.left = this.left;
        // 设置新节点的右节点为当前节点的右节点的左节点。
        newNode.right = this.right.left;
        // 设置当前节点的值为当前节点右节点的值。
        this.value = this.right.value;
        // 设置当前节点的右节点为当前节点的右节点的右节点。
        this.right = this.right.right;
        // 设置当前节点的左节点为新节点。
        this.left = newNode;
    }

    /**
     * 获取当前节点为根节点的左子树的高度。递归的方式。
     *
     * @return 当前节点为根节点的左子树的高度。
     */
    public int leftHeight() {
        return this.left == null ? 0 : this.left.height();
    }

    /**
     * 获取当前节点Wie根节点的右子树的高度。递归的方式。
     *
     * @return 当前节点为根节点的右子树的高度。递归的方式。
     */
    public int rightHeight() {
        return this.right == null ? 0 : this.right.height();
    }

    /**
     * 获取以当前节点为根节点的树的高度。递归的方式。
     * 要带上当前节点，所以 +1。
     *
     * @return 返回以当前节点为根节点的树的高度。
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(),
                this.right == null ? 0 : this.right.height()) + 1;
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
     * <p>
     * 对于平衡二叉树，在添加的时候要考虑树的平衡，即左右子树的高度差不能大于1。
     * 因此，要在添加新节点的时候，考虑树的左、右旋。
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

        // 如果右子树高度 - 左子树高度 > 1，进行左旋。降低右子树的高度。
        if (this.rightHeight() - this.leftHeight() > 1) {
            leftRotate();
        }

        // 如果左子树的高度 - 右子树高度 > 1，进行右旋。降低左子树的高度。
        if (this.leftHeight() - this.rightHeight() > 1) {
            rightRotate();
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

