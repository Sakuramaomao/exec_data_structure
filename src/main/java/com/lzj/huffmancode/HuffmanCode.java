package com.lzj.huffmancode;

import java.util.*;

/**
 * 数据压缩的实现--赫夫曼编码实战
 *
 * @Author Sakura
 * @Date 2019/11/4 8:05
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        // 1、根据赫夫曼编码压缩数据的原理，需要先创建str的赫夫曼树。
        byte[] bytes = str.getBytes();
        Node huffmanTreeRoot = createHuffmanTree(getNodes(bytes));
        huffmanTreeRoot.preOrder();

        // 2、构建赫夫曼编码表。
        Map<Byte, String> huffmanCode = getCodes(huffmanTreeRoot);
        System.out.println(huffmanCode);
    }

    // 创建huffman树。
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 1、对所有nodes对象排序。
            Collections.sort(nodes);
            // 2、取出第一个和第二个。构建二叉树。
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            // 3、删除第一个和第二个，添加新的。
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    // 重载以下getCodes方法，方便使用。
    public static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return huffmanCodes;
        } else {
            getCodes(root.left, "0", codeBuilder);
            getCodes(root.right, "1", codeBuilder);
        }
        return huffmanCodes;
    }

    // 生成huffman编码表。
    // 1、将生成的huffman编码表存放到 Map<Byte, String> 形式的集合中。
    private static final Map<Byte, String> huffmanCodes = new HashMap();
    // 2、在生成huffman编码时，需要拼接路径，定义一个StringBuilder，存储某个叶子节点的路径。
    private static final StringBuilder codeBuilder = new StringBuilder();

    /**
     * 递归的方式生成huffman编码表。
     *
     * @param node          传入节点。
     * @param code          左子节点线：0；右子节点线：1。
     * @param stringBuilder huffman编码的路径拼接。
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);

        if (node != null) { // 如果node == null，不处理。
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * 获取每个字符出现的次数。
     *
     * @param bytes 字符的ASCII锁组成的数组。
     * @return list集合，字符和字符出现次数的统计信息。
     */
    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList();
        HashMap<Byte, Integer> map = new HashMap<>();
        // 统计字符出现的次数。
        for (int i = 0; i < bytes.length; i++) {
            Integer count = map.get(bytes[i]);
            if (count == null) {
                map.put(bytes[i], 1);
            } else {
                map.put(bytes[i], count + 1);
            }
        }

        // 将字符和出现次数信息转化为node对象。
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    public static void preOrder(Node root) {
        root.preOrder();
    }
}

// 描述huffman树中节点的node类。
class Node implements Comparable<Node> {
    Byte data; // 字符对应的ASCII码。
    int weight; // 权重，记录字符出现的次数。
    Node left; // 左子节点。
    Node right; // 右子节点。

    public Node(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    // 前序遍历，方便打印huffman tree测试。
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
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 将node按照其中的weight比较，进行从小到大排列。
        return this.weight - o.weight;
    }
}
