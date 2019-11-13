package com.lzj.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
    // dfs使用，记录顶点是否被访问过。
    private boolean[] isVisited;

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

        // 测试一把dfs
        //graph.dfs();
        graph.bfs();
    }

    // n表示有多少个顶点。
    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.isVisited = new boolean[n];
    }

    /**
     * 广度优先遍历。
     */
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i])
                bfs(isVisited, i);
        }
    }

    /**
     * 对其中一个顶点进行广度优先遍历。
     *
     * @param isVisited 顶点是否被访问过的记录。
     * @param i         第几个顶点。
     */
    public void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头节点对应的下标。
        int w; // 表示邻接节点的下标。

        LinkedList<Integer> queue = new LinkedList<>();

        // 输出初始节点，并标记为已访问。
        System.out.println(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                // 以u为前驱点，找w后面的下一个邻接点。
                w = getNextNeighbor(u, w); // 体现出广度优先遍历。
            }
        }
    }

    /**
     * 遍历所有的节点，进行dfs。
     */
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 深度优先遍历。
     *
     * @param isVisited 是否被访问的标记。
     * @param i         第几个顶点。一般从 0 开始。
     */
    private void dfs(boolean[] isVisited, int i) {
        // 访问初始节点(直接输出)，并标记节点i为已访问。
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        // 查找节点i的第一个邻接节点。
        int w = getFirstNeighbor(i);
        while (w != -1) { // -1 表示没找到邻接节点。
            if (!isVisited[w]) { // 如果未被访问过，则继续dfs。
                dfs(isVisited, w);
            }
            // 如果被访问过，则查找当前邻接节点的下一个邻接节点。
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 返回当前节点的第一个邻接节点的下标。
     *
     * @param index 当前节点的下标。
     * @return 当前节点的第一个邻接节点的下标。
     */
    public int getFirstNeighbor(int index) {
        // 即找到二维数组中指定index行，这行中第一个不为0的值的下标。
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点。
     *
     * @param v1 前一个邻接节点的横坐标。
     * @param v2 前一个邻接节点的纵坐标。
     * @return 返回前一个邻接节点的下一个邻接节点的下标。
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] != 0) {
                return i;
            }
        }
        return -1;
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
