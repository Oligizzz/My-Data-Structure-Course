/*
 * @Author: 孔潇
 * @Date: 2020-04-21 16:47:15
 * @LastEditTime: 2020-04-21 20:27:31
 * @Description:  队列的顺序存储
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Queue\SeqQueue.java
 */
package app.DATASTRUCTURE.Queue;

import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class SeqQueue {
    public BiTreeChain[] data; // 数据域
    public int front;// 头指针
    public int rear;// 尾指针

    public SeqQueue(int size) {

        this.data = new BiTreeChain[size];
        for (int i = 0; i < size; i++) {
            this.data[i] = new BiTreeChain();
        }
        this.front = 0;
        this.rear = 0;
    }
}