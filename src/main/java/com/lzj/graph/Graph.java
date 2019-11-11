package com.lzj.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图 -- 无向图。
 * 节点和边是分开存储的。
 *
 * @Author Sakura
 * @Date 2019/11/11 22:04
 */
public class Graph {
    // 存储顶点的集合。
    private ArrayList<String> vertexList;
    // 存储边的集合。
    private int[][] edges;
    private int numOfEdges; // 因为边不知道有多少条，默认为0；

    public static void main(String[] args) {
        // 测试一把无向图的构建
        int n = 5; // 节点个数。
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        // 循环添加顶点。
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边。
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
    }

    // n表示有多少个顶点。
    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
    }

    // 核心的就这两个方法，一个是添加节点，一个是添加边。

    /**
     * 插入节点
     *
     * @param vertex 待插入的节点。
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边。
     * 无向图的边。
     *
     * @param v1     表示点的下标，即第几个顶点。
     * @param v2     表示点的下标，即第几个顶点。
     * @param weight 表示是否相连。1：相连。0：不相连。
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 下面编写一些常用的方法。
    // 获取图中节点的个数。
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 获取图中边的个数。
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点下标对应的数据。
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回V1和V2的权值。
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图所对应的矩阵。
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
