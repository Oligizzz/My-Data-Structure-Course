/*
 * @Author: 孔潇
 * @Date: 2020-04-29 16:56:29
 * @LastEditTime: 2020-04-29 16:56:31
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Graph\DFS&BFS\OrdGraph.java
 */
package app.DATASTRUCTURE.Graph.Ord;

import app.DATASTRUCTURE.Graph.*;
import app.DATASTRUCTURE.Graph.ALGraph.ArcNode;

public class OrdGraph_C {

  boolean visited[];

  // DFS深度优先遍历
  public void DFS(ALGraph m, int v) {
    ArcNode p;
    int w;
    visited[v] = true;// 设置已访问
    System.out.println(v);// 输出已访问编号
    p = m.adjlist.get(v).first;// p指向顶点V的第一条边的边头结点
    while (p != null) {
      w = p.adjvex;//
      if (visited[w] == false) {
        DFS(m, w);
        p = p.next;
      }
    }
  }

}