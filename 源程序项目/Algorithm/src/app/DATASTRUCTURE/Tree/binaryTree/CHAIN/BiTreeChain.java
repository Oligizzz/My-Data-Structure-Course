/*
 * @Author: 孔潇
 * @Date: 2020-04-21 14:06:23
 * @LastEditTime: 2020-04-25 01:07:23
 * @Description:  二叉树的链式存储
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Tree\binaryTree\CHAIN\BiTreeChain.java
 */
package app.DATASTRUCTURE.Tree.binaryTree.CHAIN;

public class BiTreeChain {
    public char data; // 数据域
    public BiTreeChain l_child;// 左孩子
    public BiTreeChain r_child;// 右孩子

    public BiTreeChain() {

    }

    // 二叉树创建
    public BiTreeChain CreatBiTree(String str) {
        BiTreeChain bt[] = new BiTreeChain[str.length() - 1]; // 顺序栈
        BiTreeChain b;
        BiTreeChain p = new BiTreeChain(); // 存放ch
        int top = -1;// 栈底指针
        int k = 0;
        int j = 0;

        char ch;
        b = null;
        ch = str.charAt(j); // 字符串字符选取
        while (j != str.length() - 1) {
            switch (ch) {
                case '(':
                    top++;
                    bt[top] = p;
                    k = 1;
                    break;
                case ')':
                    top--;
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    p = new BiTreeChain();
                    p.data = ch;
                    p.l_child = null;
                    p.r_child = null;
                    if (b == null) {
                        b = p;
                    } else {
                        switch (k) {
                            case 1:
                                bt[top].l_child = p;
                                break;
                            case 2:
                                bt[top].r_child = p;
                                break;
                        }
                    }
            }
            j++;
            ch = str.charAt(j);

        }
        return b;
    }

    public void BiTree_PreOrder_first(BiTreeChain biTree) {
        if (biTree != null) {
            System.out.println(biTree.data);
            BiTree_PreOrder_first(biTree.l_child);// 有几个叶子节点就会分配几个调用栈
            BiTree_PreOrder_first(biTree.r_child);
        }
    }
}