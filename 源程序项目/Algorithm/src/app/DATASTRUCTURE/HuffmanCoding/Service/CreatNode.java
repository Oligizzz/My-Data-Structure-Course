/*
 * @Author: 孔潇
 * @Date: 2020-06-29 17:05:30
 * @LastEditTime: 2020-06-29 17:05:31
 * @Description:  通过读取明文构建Huffman树节点
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Service\CreatNode.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Service;

import app.DATASTRUCTURE.HuffmanCoding.Entity.TreeNode;
import app.DATASTRUCTURE.HuffmanCoding.Utils.MyArrayList;
import app.DATASTRUCTURE.HuffmanCoding.Utils.MyHashMap;

public class CreatNode {
    
    public static MyArrayList<TreeNode> creat(String message){
        //考虑到key值唯一，value值不唯一，所以用HashMap
        MyHashMap<Character,TreeNode> map = new MyHashMap<Character,TreeNode>();
        char [] temp = message.toCharArray();

        //遍历需要发送的消息
        for (int i = 0 ; i<temp.length;i++) {
            //如果Map中没有这个关键字，直接加到Map中
            if (map.get(temp[i])==null) {
                TreeNode node = new TreeNode(temp[i]);
                map.put(temp[i],node);
            }else{//否则增加Map中这个关键字节点的权重
                TreeNode node = map.get(temp[i]);
                node.addWeight();
            }
        }

        //存放待会需要选择建树的结点
        MyArrayList<TreeNode> list = new MyArrayList<TreeNode>();
        //遍历HashMap
        for(Character s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }
}