/*
 * @Author: 孔潇
 * @Date: 2020-05-02 17:21:13
 * @LastEditTime: 2020-05-02 17:30:33
 * @Description:  假设一个无向图是非连通的，采用邻接表作为存储结构。设计一个算法，利用深度优先遍历方法求出该图连通分量个数。
 * @FilePath: \Data Structure\Algorithm\src\app\GraphTest\UnConnect.java
 */
package app.GraphTest;

import app.DATASTRUCTURE.Graph.ALGraph;
import app.DATASTRUCTURE.Graph.ALGraph.ArcNode;

public class UnConnect {

    // 算法
    boolean visited[];// 标记数组

    public int unConnect(ALGraph al) {
        this.visited = new boolean[al.n];
        for (int j = 0; j < al.n; j++) {
            this.visited[j] = false;
        }
        int counts = 0;
        for (int i = 0; i < al.n; i++) {

            if (visited[i] == false) {
                counts++;// 调用次数就是连通分量个数
                DFS(al, i);

            }
        }
        return counts;
    }

    // DFS深度优先遍历
    public void DFS(ALGraph m, int v) {
        ArcNode p;
        visited[v] = true;// 设置已访问
        // System.out.println(v);// 输出已访问编号
        p = m.adjlist.get(v).first;// p指向顶点V的第一条边的边头结点
        while (p != null) {
            if (visited[p.adjvex] == false) {
                DFS(m, p.adjvex);
                p = p.next;
            }
        }
    }

}