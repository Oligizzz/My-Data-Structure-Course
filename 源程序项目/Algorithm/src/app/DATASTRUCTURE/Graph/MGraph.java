/*
 * @Author: 孔潇
 * @Date: 2020-04-29 11:33:33
 * @LastEditTime: 2020-05-02 16:03:30
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Graph\MGraph.java
 */
package app.DATASTRUCTURE.Graph;

import java.util.ArrayList;

public class MGraph {
    public int edges[][];// 邻接矩阵
    public int n = 0;// 顶点数
    public int e = 0;// 边数
    public ArrayList<VertexType> val;// 存放顶点信息

    public class VertexType {
        public int no;// 顶点编号
        public int quanzhi;// (可以但不局限于权值）
    }

    public void Init_MGraph(int n) {
        // 邻接矩阵初始化
        int count = 0;
        this.edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 产生0或者1的随机矩阵
                this.edges[i][j] = Math.random() > 0.5 ? 0 : 1;
                if (this.edges[i][j] == 1) {
                    count++;
                }
            }
        }
        // 顶点数
        this.n = n;
        this.e = count;

        // 顶点编号初始化
        this.val = new ArrayList<VertexType>();
        for (int i = 0; i < n; i++) {
            VertexType v = new VertexType();
            v.no = i;
            v.quanzhi = 1;
            val.add(v);
        }

    }
}
