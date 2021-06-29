/*
 * @Author: 孔潇
 * @Date: 2020-04-21 15:19:23
 * @LastEditTime: 2020-05-12 20:36:15
 * @Description:  二叉树的遍历
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Tree\binaryTree\PreOrder\BiTree_PreOrder.java
 */
package app.DATASTRUCTURE.Tree.binaryTree.PreOrder;

import app.DATASTRUCTURE.Queue.SeqQueue;
import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class BiTree_PreOrder {

  // 先序遍历
  public void BiTree_PreOrder_first(BiTreeChain biTree) {
    if (biTree != null) {
      System.out.print(biTree.data + " ");
      BiTree_PreOrder_first(biTree.l_child);// 有几个叶子节点就会分配几个调用栈
      BiTree_PreOrder_first(biTree.r_child);
    }
  }

  // 中序遍历
  public void BiTree_PreOrder_mid(BiTreeChain biTree) {
    if (biTree != null) {
      BiTree_PreOrder_first(biTree.l_child);
      System.out.print(biTree.data + " ");
      BiTree_PreOrder_first(biTree.r_child);
    }
  }

  // 后序遍历
  public void BiTree_PreOrder_last(BiTreeChain biTree) {
    if (biTree != null) {
      BiTree_PreOrder_first(biTree.l_child);
      BiTree_PreOrder_first(biTree.r_child);
      System.out.print(biTree.data + " ");
    }
  }

  // 层序遍历
  public void BiTree_PreOrder_layer(BiTreeChain biTree, int n) {
    SeqQueue sq = new SeqQueue(n);
    sq.rear = (sq.rear + 1) % n;
    sq.data[sq.rear] = biTree;

    while (sq.front != sq.rear) {
      sq.front = (sq.front + 1) % n;
      System.out.print(sq.data[sq.front].data);
      BiTreeChain p = sq.data[sq.front];

      if (p.l_child != null) {
        sq.data[++sq.rear] = biTree.l_child;
      } else if (p.r_child != null) {

        sq.data[++sq.rear] = biTree.r_child;
      } else {
        sq.front++;
      }
    }
  }

}