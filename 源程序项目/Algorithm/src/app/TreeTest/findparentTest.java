/*
 * @Author: 孔潇
 * @Date: 2020-04-24 18:21:30
 * @LastEditTime: 2020-04-25 17:27:15
 * @Description:  假设二叉树中每个节点值为单个字符，采用二叉链存储结构存储。
 *                设计一个算法void findparent(BTNode *b，char x，BTNode *&p)
 *                求二叉树b中指定值为x的节点的双亲节点p，
 *   提示：根节点的双亲为NULL，若在b中未找到值为x的节点，p亦为NULL，并假设二叉树中所有节点值是唯一的。
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\findparentTest.java
 */
package app.TreeTest;

import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class findparentTest {

    // 算法
    public BiTreeChain findparent(BiTreeChain bi, char x) {

        if (bi == null) {// 空结点返回空
            return null;
        } else {
            if (bi.data == x) {// 直接返回根结点（双亲为null已在主函数处理），否则空指针异常
                return bi;
            }
            if (bi.l_child != null && bi.l_child.data == x) {// 有左孩子且数据域为X，符合条件的双亲
                return bi;
            }

            if (bi.r_child != null && bi.r_child.data == x) {// 有右孩子且数据域为X，也是符合条件的双亲
                return bi;
            }

            BiTreeChain par;
            // 分别递归左右子树
            if ((par = findparent(bi.l_child, x)) != null) {
                return par;
            } else {
                return findparent(bi.r_child, x);
            }
        }

    }
}