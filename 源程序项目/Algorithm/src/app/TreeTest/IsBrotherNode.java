/*
 * @Author: 孔潇
 * @Date: 2020-04-25 16:22:31
 * @LastEditTime: 2020-04-25 17:39:28
 * @Description:  假设二叉树中每个节点值为单个字符，采用二叉链存储结构存储。
 * 设计一个算法，判断值为x的节点与值为y的节点是否互为兄弟，假设这样的节点值是唯一的。
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\IsBrotherNode.java
 */
package app.TreeTest;

import java.util.LinkedList;
import java.util.Queue;

import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class IsBrotherNode {

    // 算法1（递归）
    // 只要能找到左右孩子存在且数据域为x和y的结点（双亲）就说明他俩是兄弟
    public BiTreeChain isBrother(BiTreeChain bi, char x, char y) {

        if (bi == null) {
            return null;
        }
        if (bi.l_child != null && bi.l_child.data == x) {
            if (bi.r_child != null && bi.r_child.data == y) {
                return bi;
            }
            return null;
        }
        if (bi.r_child != null && bi.r_child.data == x) {
            if (bi.l_child != null && bi.l_child.data == y) {
                return bi;
            }
            return null;
        }

        BiTreeChain reTree;
        if ((reTree = isBrother(bi.l_child, x, y)) != null) {
            return reTree;
        } else {
            return isBrother(bi.r_child, x, y);
        }
    }

    // 算法2（层序遍历）
    public boolean isBrother2(BiTreeChain bi, char x, char y) {
        boolean b = false;
        if (bi == null) {
            return false;
        }

        Queue<BiTreeChain> q = new LinkedList<>();// 链式队列构造
        BiTreeChain temp = null;
        int front = -1;
        int rear = -1;
        int last = 0;

        q.offer(bi);// 根节点入队
        rear++;

        while (q.size() != 0) {// 队不空循环

            temp = q.poll();// 出队一个元素
            front++;
            if (temp.l_child != null && temp.l_child.data == x) {
                if (temp.r_child != null && temp.r_child.data == y) {
                    b = true;

                }
                break;

            }
            if (temp.r_child != null && temp.r_child.data == x) {
                if (temp.l_child != null && temp.l_child.data == y) {
                    b = true;
                }
                break;
            }

            // 有左孩子（不是叶子节点）入队
            if (temp.l_child != null) {
                q.offer(temp.l_child);
                rear++;
            }
            // 有右孩子（不是叶子节点）入队
            if (temp.r_child != null) {
                q.offer(temp.r_child);
                rear++;
            }

            if (front == last) {
                last = rear;
            }

        }

        return b;
    }
}