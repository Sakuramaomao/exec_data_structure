package com.lzj.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 自己构建一个赫夫曼树。
 *
 * @Author Sakura
 * @Date 2019/11/3 18:54
 */
public class HuffManTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffManTreeRoot = createHuffManTree(arr);
        preOrder(huffManTreeRoot);
    }

    /**
     * 创建赫夫曼树。
     *
     * @param arr 数值数组。
     * @return huffman树头节点。
     */
    public static Node createHuffManTree(int[] arr) {
        // 1、预处理。将数组中元素转化为Node对象。
        ArrayList<Node> nodes = new ArrayList();
        for (int i : arr) {
            nodes.add(new Node(i));
        }

        while (nodes.size() > 1) { // 当nodes中只剩一个元素时，表明huffman树构建完毕，退出循环。
            // 2、对集合中的node进行排序。
            Collections.sort(nodes);

            // 3、取出前两个node构建成新的二叉树。
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            // 4、最后一步。从nodes中删除这两个node，并且将新的parentNode存入。
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }

        return nodes.get(0);
    }

    // 前序遍历。便于测试构建的huffman树是否正确。
    public static void preOrder(Node root) {
        root.preOrder();
    }
}

// 定义描述huffman树节点的类。
class Node implements Comparable<Node> {
    int value; // 节点的权值。
    Node left; // 左子节点。
    Node right; // 右子节点。

    public Node(int value) {
        this.value = value;
    }

    // 前序遍历。便于测试构建的huffman树是否正确。
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 因为想让Node从小到大排序，所以用this的value和o的value相减。
        return this.value - o.value;
    }
}
