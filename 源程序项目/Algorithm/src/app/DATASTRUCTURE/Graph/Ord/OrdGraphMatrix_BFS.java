/*
 * @Author: 孔潇
 * @Date: 2020-05-02 14:25:56
 * @LastEditTime: 2020-05-02 14:25:57
 * @Description:  假设图G采用邻接矩阵存储。给出图的广度优先遍历算法，并分析算法的时间复杂度
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Graph\Ord\OrdGraphMatrix_BFS.java
 */
package app.DATASTRUCTURE.Graph.Ord;

import java.util.LinkedList;
import java.util.Queue;
import app.DATASTRUCTURE.Graph.MGraph;
import app.DATASTRUCTURE.Graph.MGraph.VertexType;

public class OrdGraphMatrix_BFS {

    // 算法
    public void OrdMat_BFS(MGraph G) {

        boolean visited[] = new boolean[G.n];// 记录是否访问过
        for (int i = 0; i < G.n; i++) {
            visited[i] = false;
        }

        // 初始化一个队列
        Queue<VertexType> queue = new LinkedList<VertexType>();

        // 开始工作
        for (int i = 0; i < G.n; i++) {

            if (!visited[i]) {

                System.out.print(G.val.get(i).no + " ");// 访问顶点（G.val.get(i).no获取顶点编号）
                visited[i] = true;// 访问过标记
                queue.offer(G.val.get(i));// 入队

                // 队不空循环
                while (!queue.isEmpty()) {
                    // 出队一个顶点并且获取它的编号
                    i = queue.remove().no;
                    for (int j = 0; j < G.n; j++) {
                        // 如果顶点i到顶点j有有向边，并且还没有被访问过
                        if (G.edges[i][j] == 1 && !visited[j]) {
                            // 那么就访问它
                            System.out.print(G.val.get(j).no + " ");
                            visited[j] = true;// 访问过标记
                            queue.offer(G.val.get(j));// 把访问过的入队
                        }
                    }
                }
            }
        }

    }
}