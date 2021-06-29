/*
 * @Author: 孔潇
 * @Date: 2020-04-21 14:04:12
 * @LastEditTime: 2020-04-21 14:04:13
 * @Description:  二叉树的顺序存储结构
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Tree\binaryTree\SEQ\BiTreeSeq.java
 */
package app.DATASTRUCTURE.Tree.binaryTree.SEQ;

public class BiTreeSeq {

    public PTNode nodes[];
    public int r; // 根的位置
    public int n; // 结点数目

    // 构造方法
    public BiTreeSeq(int count) {
        this.nodes = new PTNode[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new PTNode();
        }
        this.r = -1;
        this.n = count;
    }

    public class PTNode {
        public char data; // 节点数据
        public int parent = -1; // 双亲位置
    }

}