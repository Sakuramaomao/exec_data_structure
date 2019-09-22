package com.lzj.tree;

/**
 * 定义二叉树的节点类
 * @Author Sakura
 * @Date 2019/2/27 21:08
 */
public class TreeNode<T> {

    private int index; // 下标。

    private T data; // 数据域。

    private TreeNode lChild; // 左节点。

    private TreeNode rChild; // 右节点。

    /**
     * 构造函数，节点初始化时只需下标和数据域即可。
     * 不会知道其孩子节点的任何信息（父亲出生时是不可能知道其有没有儿子的）。
     * @param index
     * @param data
     */
    public TreeNode(int index, T data) {
        this.index = index;
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public TreeNode getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }
}
