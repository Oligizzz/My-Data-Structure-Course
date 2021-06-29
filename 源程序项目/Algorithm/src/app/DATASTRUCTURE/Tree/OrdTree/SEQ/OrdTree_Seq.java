/*
 * @Author: 孔潇
 * @Date: 2020-04-17 19:33:44
 * @LastEditTime: 2020-04-18 23:18:20
 * @Description:  
 * @FilePath: \Algorithm\src\app\DATASTRUCTURE\Tree\OrdTree\OrdTree_Seq.java
 */
package app.DATASTRUCTURE.Tree.OrdTree.SEQ;



//树的顺序存储结构
//双亲表示法

public class OrdTree_Seq {
    public PTNode nodes [];
    public int r;           //根的位置
    public int n;           //结点数目

    //构造方法
    public OrdTree_Seq(int count) {
        this.nodes = new PTNode[count];
        for (int i = 0;i<count;i++) {
            nodes[i]=new PTNode();
        }
        this.r = -1;
        this.n = count;
    }

    public class PTNode {
        public char data; // 节点数据
        public int parent = -1; // 双亲位置

        // int chi1; //孩子一
        // int chil2; //孩子二
        // ...
        // int chiln; //孩子n

    }

    //创建一个顺序存储的二叉树
    public OrdTree_Seq creatptree(int n){   
        
        OrdTree_Seq o = new OrdTree_Seq(n);
        int i;
        o.r=1;
        o.n=n;

        for(i=0;i<o.n;i++){
            PTNode p = new PTNode();
            p.data="ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i);
            p.parent = i/2;
            o.nodes[i] = p;
        }
        return o;
    }
}

 