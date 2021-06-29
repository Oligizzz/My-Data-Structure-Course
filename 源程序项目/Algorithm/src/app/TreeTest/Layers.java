/*
 * @Author: 孔潇
 * @Date: 2020-04-18 13:44:11
 * @LastEditTime: 2020-04-19 02:20:01
 * @Description:  假设非空二叉树采用顺序存储结构，每个节点值为单个字符。
 *                设计一个算法求编号为i的节点的层次。
 * @FilePath: \JAVA\Data Structure\Algorithm\src\app\TreeTest\Layers.java
 */
package app.TreeTest;

public class Layers {

    // 算法
    public int search_layers(int i) {
        int layers = 0; // 当前层数
        int counts = 0; // 当前总数
        while (counts <= i) {
            if (counts == i) { // i在当前层最后一个元素
                break;
            } else { // i在当前层之后
                layers++;
                counts = counts + (int) Math.pow(2, layers - 1);
            }
        }
        return layers;
    }
}