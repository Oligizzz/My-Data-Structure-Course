/*
 * @Author: 孔潇
 * @Date: 2020-06-29 12:54:49
 * @LastEditTime: 2020-07-01 14:10:02
 * @Description:  Huffman树结点
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Entity\TreeNode.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Entity;

public class TreeNode {

    private char name;// 字符节点名
    private int weight = 1;// 权重
    public String code = "";// 节点的哈夫曼编码
    private TreeNode lchild = null;// 左孩子
    private TreeNode rchild = null;// 右孩子

    public TreeNode() {
    }

    public TreeNode(char name) {
        this.name = name;
    }

    // 权值增加
    public void addWeight() {
        this.weight++;
    }

    public void setNane(char name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLchild(TreeNode node) {
        this.lchild = node;
    }

    public void setRchild(TreeNode node) {
        this.rchild = node;
    }

    public char getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public TreeNode getLchild() {
        return this.lchild;
    }

    public TreeNode getRchild() {
        return this.rchild;
    }

}