/*
 * @Author: 孔潇
 * @Date: 2020-06-30 12:46:02
 * @LastEditTime: 2020-07-01 22:38:00
 * @Description:  哈夫曼树构建
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Service\CreatTree.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Service;

import java.io.IOException;

import app.DATASTRUCTURE.HuffmanCoding.Dao.GetMessage;
import app.DATASTRUCTURE.HuffmanCoding.Entity.*;
import app.DATASTRUCTURE.HuffmanCoding.Sort.sortForArrayList;
import app.DATASTRUCTURE.HuffmanCoding.Utils.*;

public class CreatTree {
    GetMessage gg = new GetMessage();

    MyArrayList<TreeNode> list;

    public TreeNode Creat(String message) throws IOException {

        gg.getMessageForConsole();
        list = CreatNode.creat(message);

        sortForArrayList.sort(list, 0, list.size());

        // 每次选取两个最小的结点
        while (list.size() > 1) {
            TreeNode left = (TreeNode) list.get(0);
            TreeNode right = (TreeNode) list.get(1);
            TreeNode father = new TreeNode();
            father.setLchild(left);
            father.setRchild(right);
            father.setWeight(left.getWeight() + right.getWeight());
            list.remove(0);
            list.remove(0);
            list.insert(0, father);
            // 再排序
            sortForArrayList.sort(list, 0, list.size());

        }
        return (TreeNode) list.get(0);
    }

}