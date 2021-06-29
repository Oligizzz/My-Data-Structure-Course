/*
 * @Author: 孔潇
 * @Date: 2020-04-29 12:18:57
 * @LastEditTime: 2020-05-02 22:13:38
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Graph\ALGraph.java
 */
package app.DATASTRUCTURE.Graph;

import java.util.ArrayList;
import static java.lang.Double.POSITIVE_INFINITY;

//数组+链表
public class ALGraph {
    public ArrayList<VNode> adjlist;
    public int n;// 顶点数
    public int e;// 边数

    // 头结点
    public class VNode {
        public int data; // 顶点信息
        public ArcNode first;// 头结点指向第一条边末端顶点

        VNode() {
            this.data = 0;
            this.first = null;
        }
    }

    // 结点存储结构
    public class ArcNode {
        public int adjvex;// 该边的终点编号
        public ArcNode next;// 指向下一条边的末端顶点
    }

    // 通过一个邻接矩阵创建邻接表
    public void InitALGraph(MGraph G) {
        int A[][] = G.edges;
        int i, j;

        this.adjlist = new ArrayList<>();
        for (i = 0; i < n; i++) {// 给邻接表中所有头结点的指针域置初值NULL
            adjlist.get(i).first = null;
        }

        for (i = 0; i < G.n; i++) {
            VNode v = new VNode();
            for (j = G.n - 1; j >= 0; j--) {
                // 有一条边
                if (A[i][j] != 0 && A[i][j] != POSITIVE_INFINITY) {
                    ArcNode p = new ArcNode();
                    p.adjvex = j;
                    p.next = v.first;
                    v.first = p;
                }
            }
            System.out.println("集合" + v.data);
            this.adjlist.add(v);
        }
        this.n = G.n;
        this.e = G.e;
    }

    public void show(ALGraph al) {

        for (int i = 0; i < al.n; i++) {
            ArcNode p = al.adjlist.get(i).first;
            System.out.print("顶点：" + i + ":     " + i + "->");
            while (p != null) {

                System.out.print(p.adjvex + "->");
                p = p.next;
            }
            System.out.print("null");
            System.out.print("\n");
        }
    }
}
