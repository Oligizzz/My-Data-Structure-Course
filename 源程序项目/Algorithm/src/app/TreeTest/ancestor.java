/*
 * @Author: 孔潇
 * @Date: 2020-04-18 17:09:01
 * @LastEditTime: 2020-04-18 23:07:55
 * @Description:  假设非空二叉树采用顺序存储结构，每个节点值为单个字符。
 *                设计一个算法输出编号为i的节点的所有祖先节点值。
 * @FilePath: \Algorithm\src\app\TreeTest\ancestor.java
 */
package app.TreeTest;


import app.DATASTRUCTURE.Tree.OrdTree.SEQ.OrdTree_Seq;

public class ancestor {

    //算法
    public void show_ancestor(OrdTree_Seq o,int n,int i) {
        int j= 0; 
        if (i<=1 || i>n) return; 
        else { 
            j=i/2; 
            while (j!=0) { 
                System.out.print(o.nodes[j].data+" "); 
                j=j/2; 
            } 
        }        
    }

}