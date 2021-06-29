/*
 * @Author: 孔潇
 * @Date: 2020-05-11 13:23:35
 * @LastEditTime: 2020-05-11 15:08:46
            * @Description:  假设图采用邻接矩阵存储。修改Dijkstra算法，仅求从顶点u到顶点v的最短路径及其长度。
 * @FilePath: \Data Structure\Algorithm\src\app\GraphTest\DijkstraUV.java
 */
package app.GraphTest;

import app.DATASTRUCTURE.Graph.MGraph;

public class DijkstraUV {
    final int INF = Integer.MAX_VALUE;

    // 算法
    public void Find_Dijks(MGraph G, int u, int v) {

        int dis = 0;// 最短距离
        boolean visited[] = new boolean[G.n];// 该结点是否访问
        int dist[] = new int[G.n];// 刷新距离
        int par[] = new int[G.n];// 记录最短前驱

        // 初始化
        for (int init = 0; init < G.n; init++) {
            visited[init] = false;
            dist[init] = G.edges[u][init]; // u到init有边
            par[init] = -1;
            // 区分对角线和无穷边
            if (dist[init] != INF) {
                par[init] = u;
            }
        }
        // u为源初始化
        visited[u] = true;
        dist[u] = 0;

        for (int i = 0; i < visited.length; i++) {
            int min = INF;
            int k = 0;

            // 找到最近的点
            for (int j = 0; j < visited.length; j++) {
                // 没有访问过，并且到这点的距离较小
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];// 刷新最短距离
                    k = j;// 标记访问过
                }
            }
            visited[k] = true;

            // 更新最短路径和前驱结点
            for (int j = 0; j < visited.length; j++) {
                if (!visited[j] && G.edges[k][j] != INF) {
                    // u 直接到 j 的距离大于 u到k + k到j 的距离
                    if (dist[j] > G.edges[k][j] + dist[k]) {

                        dist[j] = G.edges[k][j] + dist[k];
                        par[j] = k;
                    }
                }

                // 点到为止
                if (k == v) {
                    break;
                }
            }

        }
        dis = dist[v];
        // 打印路径

        System.out.println("最短路径为：");
        System.out.println(u);

        for (int i = 0; i < par.length; i++) {
            System.out.println(par[i]);
        }
        int temp = par[v];
        while (temp != u) {
            System.out.print(temp + " ");
            temp = par[temp];
        }
        System.out.println("\n" + "最短路径长度为：" + dis);

    }
}