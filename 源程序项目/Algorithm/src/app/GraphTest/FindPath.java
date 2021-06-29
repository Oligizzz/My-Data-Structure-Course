/*
 * @Author: 孔潇
 * @Date: 2020-05-02 18:40:06
 * @LastEditTime: 2020-05-02 22:44:40
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\GraphTest\FindPath.java
 */
package app.GraphTest;

import app.DATASTRUCTURE.Graph.ALGraph;
import app.DATASTRUCTURE.Graph.ALGraph.ArcNode;

public class FindPath {

  boolean visited[] = new boolean[100];

  // 求出符合条件的u,v之间的简单路径
  public void isPath(ALGraph al, int u, int v, int path[], int d) {

    int w;
    ArcNode p;
    d++;
    path[d] = u;
    visited[u] = true;
    if (u == v && isRight(path, d)) {
      System.out.println("合法路径为：");
      for (int i = 0; i < d; i++) {
        System.out.print("->" + path[i]);
      }
      System.out.print("\n");
    }
    p = al.adjlist.get(u).first;
    while (p != null) {
      w = p.adjvex;
      if (visited[w] == false) {
        isPath(al, w, v, path, d);
      }
      p = p.next;
    }
    visited[u] = false;
    d--;
  }

  int n = 2;// 必经点个数
  int m = 2;// 必避点个数
  int V1[] = { 1, 6 };// 必经点集合
  int V2[] = { 7, 9 }; // 必避点集合
  int cnt = 0;

  public boolean isRight(int path[], int d) {
    int flag1 = 0, f1;
    int flag2 = 0, f2;
    int i, j;

    // 判断路径中是否有必经点
    for (i = 0; i < n; i++) {
      f1 = 1;
      for (j = 0; j <= d; j++) {
        if (path[j] == V1[i]) {
          f1 = 0;
          break;
        }
      }
      flag1 += f1;
    }

    // 判断路径中是否有必避点
    for (i = 0; i < m; i++) {
      f2 = 0;
      for (j = 0; j <= d; j++) {
        if (path[j] == V2[i]) {
          f2 = 1;
          break;
        }
      }
      flag2 += f2;
    }

    if (flag1 == 0 && flag2 == 0) {// 满足条件返回true
      return true;
    } else {// 不满足条件返回false
      return false;
    }
  }

}