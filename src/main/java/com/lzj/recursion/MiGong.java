package com.lzj.recursion;

/**
 * 递归的应用：求解迷宫问题。
 *
 * @Author Sakura
 * @Date 2019/10/7 19:28
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[7][6]; // 7 * 6的地图。
        // 画墙。
        for (int i = 0; i < 6; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][5] = 1;
        }
        // 画障碍。
        map[2][1] = 1;
        map[2][2] = 1;
        System.out.println("原始的地图为：");
        listMap(map);
        stepBy(map, 1, 1);
        System.out.println("走通的地图为：");
        listMap(map);
    }

    // 遍历地图。
    private static void listMap(int[][] map) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 求解迷宫。
     * <p>
     * 7*6地图，小球最终要到达map[6][5]目的地。
     * 约定 map[i][j] 值的含义：
     * 0：表示小球还没走过。
     * 1：墙壁。
     * 2：表示小球可以走。
     * 3；表示改点可以走，但是走不通。
     *
     * 思路：
     * 1、如果到终点
     *      return true（结束递归）
     * 2、如果未到终点
     *      （1）如果可走（设置为0）
     *          走入这个点（设置为2）
     *          开始判断这个点的四周是否可走
     *          1、下面可走
     *              return true
     *          2、右面可走
     *              return true
     *          3、上面可走
     *              return true
     *          4、左面可走
     *              return true
     *          5、以上都不能走
     *              这是一个死点（设置为3）
     *              return false
     *      （2）如果不可走（不为0）
     *          return false
     *
     * @param map 地图
     * @param i   小球起始位置横坐标。
     * @param j   小球起始位置纵坐标。
     * @return boolean
     */
    private static boolean stepBy(int[][] map, int i, int j) {
        if (map[5][4] == 2) { // 已找到终点。
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个节点还没走过。
                // 按照策略 下右上左 走。
                map[i][j] = 2; // 假定该点可以走。
                if (stepBy(map, i + 1, j)) {
                    return true;
                } else if (stepBy(map, i, j + 1)) {
                    return true;
                } else if (stepBy(map, i - 1, j)) {
                    return true;
                } else if (stepBy(map, i, j - 1)) {
                    return true;
                } else {
                    // 说明该点走不通，是死路。
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 !=0 ，那么有可能是1,2,3
                return false;
            }
        }
    }
}
