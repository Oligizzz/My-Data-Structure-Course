/*
 * @Author: 孔潇
 * @Date: 2020-05-12 16:54:37
 * @LastEditTime: 2020-05-12 20:47:38
 * @Description:  树的常规应用
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Tree\binaryTree\TreeApplication\OrdApplication.java
 */
package app.DATASTRUCTURE.Tree.binaryTree.TreeApplication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import app.DATASTRUCTURE.Tree.binaryTree.CHAIN.BiTreeChain;

public class OrdApplication {

    public int depth = 0;// 深度
    public int width = 0;// 宽度
    public int Nodes = 0;// 结点数
    public int Nodes_single = 0;// 单分支结点
    public int Nodes_Layer = 0;// 叶子结点

    // 求树的最大深度(递归)
    public int TreeDepth(BiTreeChain root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.l_child);
        int right = TreeDepth(root.r_child);
        return left > right ? left + 1 : right + 1;
    }

    // 求树的最大深度（队列层序）
    public int TreeDepth1(BiTreeChain root) {
        if (root == null) {
            return 0;
        }
        int deep = 0, count = 0, nextCount = 1;
        Queue<BiTreeChain> queue = new LinkedList<BiTreeChain>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BiTreeChain p = queue.poll();
            count++;
            if (p.l_child != null) {
                queue.add(p.l_child);
            }
            if (p.r_child != null) {
                queue.add(p.r_child);
            }
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                deep++;
            }
        }
        depth = deep;
        return deep;
    }

    // 统计二叉树的节点个数
    public int nodes(BiTreeChain biTree) {
        if (biTree == null) {
            return 0;
        } else {
            int l = nodes(biTree.l_child);
            int r = nodes(biTree.r_child);
            if (l == 0 && r == 0) {
                return 1;
            } else {
                return l + r;
            }
        }

    }

    // 叶子节点个数(递归)
    public void getCountRec(BiTreeChain root) {
        if (root == null) {
            return;
        }
        if (root.l_child == null && root.r_child == null) {
            Nodes_Layer++;
        }
        getCountRec(root.l_child);
        getCountRec(root.r_child);
    }

    // 叶子节点个数(非递归)
    public int getCountsOfLeaves(BiTreeChain root) {
        int count = 0;

        if (root == null) {
            return count;
        }
        Stack<BiTreeChain> stack = new Stack<BiTreeChain>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BiTreeChain node = stack.pop();
            if (node.l_child == null && node.r_child == null) {
                count++;
            }
            if (node.l_child != null) {
                stack.push(node.l_child);
            }
            if (node.r_child != null) {
                stack.push(node.r_child);
            }
        }
        Nodes_Layer = count;
        return count;
    }

    // 统计度为1的结点个数(递归)
    public int node_single(BiTreeChain root) {
        if (root == null) {
            return 0;
        } else {
            if (root.l_child != null && root.r_child == null) {
                Nodes_single++;
            }
            if (root.l_child == null && root.r_child != null) {
                Nodes_single++;
            }
            int l = node_single(root.l_child);
            int r = node_single(root.r_child);
            return l + r;
        }

    }

    // 统计度为1的结点个数(非递归)
    public int node_single2(BiTreeChain root) {
        int counts = 0;
        if (root == null) {
            return counts;
        }
        Stack<BiTreeChain> stack = new Stack<BiTreeChain>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BiTreeChain node = stack.pop();
            if (node.l_child != null && node.r_child != null) {
                stack.push(node.l_child);
                stack.push(node.r_child);
            }
            if (node.l_child != null && node.r_child == null) {
                counts++;
                stack.push(node.l_child);
            }
            if (node.r_child != null && node.l_child == null) {
                counts++;
                stack.push(node.r_child);
            }
        }
        Nodes_single = counts;
        return counts;
    }

    // 输出二叉树中从每个叶子结点到根结点的路径(递归)
    public void Route(BiTreeChain root, char path[], int pathlen) { // 输出二叉树中从每个叶子结点到根结点的路径
        if (root == null) {
            return;
        }
        if (root.l_child == null && root.r_child == null) {
            path[pathlen++] = root.data;
            System.out.println("叶子节点" + root.data + "到根节点的路径为： ");
            for (int i = pathlen - 1; i >= 0; i--) {
                System.out.print(path[i] + "-->");
            }
            System.out.print("\n");
        } else {
            path[pathlen++] = root.data;
            Route(root.l_child, path, pathlen);
            Route(root.r_child, path, pathlen);
        }
    }

}

/*
 * showMenu(); BiTreeChain tree = new BiTreeChain();// 构造树 BiTree_PreOrder ord =
 * new BiTree_PreOrder();// 遍历类 OrdApplication a = new OrdApplication();// 应用类
 * char path[] = new char[20]; int pathlen = 0;
 * System.out.println("        ==>请选择算法序号...\n"); int exit = 1; while (exit !=
 * 0) { Scanner input = new Scanner(System.in); int ch = input.nextInt(); switch
 * (ch) { case 1: { System.out.println("请输入树的逻辑表示（例如：A(B,C(,E))）"); Scanner
 * input2 = new Scanner(System.in); String str = input2.next(); tree =
 * tree.CreatBiTree(str); System.out.println("二叉树创建成功！");
 * System.out.println("==>请选择算法序号...\n"); break; } case 2:
 * System.out.println("二叉树中序遍历结果："); ord.BiTree_PreOrder_mid(tree);
 * System.out.println("\n==>请选择算法序号...\n"); break; case 3:
 * System.out.println("二叉树前序遍历结果："); ord.BiTree_PreOrder_first(tree);
 * System.out.println("\n==>请选择算法序号...\n"); break; case 4:
 * System.out.println("二叉树后序遍历结果："); ord.BiTree_PreOrder_last(tree);
 * System.out.println("\n==>请选择算法序号...\n"); break; case 5: {
 * System.out.println("二叉树的最大深度是：" + a.TreeDepth(tree));
 * System.out.println("==>请选择算法序号...\n"); break; } case 6:
 * System.out.println("二叉树的结点数是：" + a.nodes(tree));
 * System.out.println("==>请选择算法序号...\n"); break; case 7: a.getCountRec(tree);
 * System.out.println("二叉树的叶子结点数是：" + a.Nodes_Layer);
 * System.out.println("==>请选择算法序号...\n"); break; case 8: a.node_single(tree);
 * System.out.println("二叉树的入度为1的结点数是：" + a.Nodes_single);
 * System.out.println("==>请选择算法序号...\n"); break; case 9: a.Route(tree, path,
 * pathlen); System.out.println("==>请选择算法序号...\n"); break; case 0:
 * System.out.println("退出！"); exit = 0; break; default:
 * System.out.println("输入错误！"); System.out.println("==>请选择算法序号...\n"); break;
 * 
 * } }
 * 
 * 
 * public static void showMenu() {
 * System.out.println("====================================================");
 * System.out.println("----------数据结构实验——二叉树的基本操作------------");
 * System.out.println("\n        用递归的方法实现以下任一算法");
 * System.out.println("         ⚐⚐⚐ 1    以二叉链表表示二叉树，建立一棵二叉树");
 * System.out.println("         ⚐⚐⚐ 2    输出二叉树的中序遍历结果");
 * System.out.println("         ⚐⚐⚐ 3    输出二叉树的前序遍历结果");
 * System.out.println("         ⚐⚐⚐ 4    输出二叉树的后序遍历结果");
 * System.out.println("         ⚐⚐⚐ 5    计算二叉树的深度");
 * System.out.println("         ⚐⚐⚐ 6    统计二叉树的结点个数");
 * System.out.println("         ⚐⚐⚐ 7    统计二叉树的叶结点个数");
 * System.out.println("         ⚐⚐⚐ 8    统计二叉树的度为1的结点个数");
 * System.out.println("         ⚐⚐⚐ 9    输出二叉树中从每个叶子结点到根结点的路径"); }
 */