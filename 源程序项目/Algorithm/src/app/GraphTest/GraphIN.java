/*
 * @Author: 孔潇
 * @Date: 2020-05-02 13:33:17
 * @LastEditTime: 2020-05-02 14:13:37
 * @Description:  假设不带权有向图G采用邻接矩阵存储，设计一个算法求出图G中每个顶点的入度
 * @FilePath: \Data Structure\Algorithm\src\app\GraphTest\GraphIN.java
 */
package app.GraphTest;

public class GraphIN {
    public int result[];// 存储结果

    // 算法
    public void IN(int AdjMatrix[][]) {
        result = new int[AdjMatrix.length];
        // 遍历二维数组，列优先
        for (int i = 0; i < AdjMatrix.length; i++) {
            int count = 0;// 入边数
            int j;
            for (j = 0; j < AdjMatrix.length; j++) {
                if (AdjMatrix[j][i] == 1) {
                    count++;
                }
            }
            result[i] = count;
        }

    }

    // 结果输出；
    public void showResult(int result[]) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("顶点" + i + "的入度为： " + result[i]);
        }
    }

}
