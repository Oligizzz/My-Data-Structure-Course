/*
 * @Author: 孔潇
 * @Date: 2020-04-25 13:41:55
 * @LastEditTime: 2020-04-25 16:16:09
 * @Description:  假设二叉树中每个节点值为单个字符，采用二叉链存储结构存储。
 * 设计一个算法求二叉树b的最小枝长。所谓最小最小枝长是指的是根节点到最近叶子节点的路径长度。
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\minLength.java
 */
package app.TreeTest;

import java.util.LinkedList;
import java.util.Queue;
import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class minLength {

    // 算法_1(层序遍历思想)
    public int get_minLength(BiTreeChain bi) {
        if (bi == null) {
            return 0;
        }

        Queue<BiTreeChain> q = new LinkedList<>();// 链式队列构造
        BiTreeChain temp = null;
        int front = -1;
        int rear = -1;
        int last = 0;
        int length = 0;// 最短路径长度

        q.offer(bi);// 根节点入队
        rear++;

        while (q.size() != 0) {// 队不空循环

            temp = q.poll();// 出队一个元素
            front++;

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

            // 第一次遇到叶子节点就退出while并返回Length
            if (temp.l_child == null && temp.r_child == null) {
                break;
            }
            if (front == last) {
                length++;
                last = rear;
            }

        }

        return length;
    }

    // 算法_2(递归)
    public int get_minLength2(BiTreeChain bi) {
        int min1 = 0;
        int min2 = 0;
        if (bi == null) {
            return 0;
        } else if (min1 > min2) {
            return min2;// 取右边的路径+1
        } else if (min2 > min1) {
            return min1;// 取左边的路径+1
        } else if (bi.l_child == null && bi.r_child == null) {
            // 应为求的路径最小值，不增加（层数就得return1）
            return 0;
        } else {
            min1 = get_minLength2(bi.l_child);
            min2 = get_minLength2(bi.r_child);
            // 取两边最小值
            return Math.min(min1, min2) + 1;
        }
    }

}
