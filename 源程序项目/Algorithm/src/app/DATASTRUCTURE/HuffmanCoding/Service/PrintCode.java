/*
 * @Author: 孔潇
 * @Date: 2020-07-01 22:18:13
 * @LastEditTime: 2020-07-01 22:18:14
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Service\PrintCode.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Service;

import app.DATASTRUCTURE.HuffmanCoding.Dao.Result;
import app.DATASTRUCTURE.HuffmanCoding.Entity.TreeNode;

public class PrintCode {
    String result = "";

    public void printcode(TreeNode node, Result res) {

        if (node.getLchild() == null && node.getRchild() == null) {
            result = result + (node.getName() + " " + node.code + "\n");
            return;
        } else if (node.getLchild() != null && node.getRchild() == null) {
            node.getLchild().code = node.code + "0";
        } else if (node.getRchild() != null && node.getLchild() == null) {
            node.getRchild().code = node.code + "1";
        } else {
            node.getLchild().code = node.code + "0";
            node.getRchild().code = node.code + "1";
        }
        printcode(node.getLchild(), res);
        printcode(node.getRchild(), res);
    }

    public String getResult() {
        return this.result;
    }

}
