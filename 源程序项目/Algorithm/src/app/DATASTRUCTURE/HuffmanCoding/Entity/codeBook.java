/*
 * @Author: 孔潇
 * @Date: 2020-07-02 17:48:08
 * @LastEditTime: 2020-07-02 17:48:09
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Entity\codeBook.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Entity;

import java.util.ArrayList;

import app.DATASTRUCTURE.Test.node;

public class codeBook {

    public static ArrayList<node> list = new ArrayList<>();

    public void add(node node) {
        list.add(node);
    }

    public node get(int loc) {
        return (node) list.get(loc);
    }
}
