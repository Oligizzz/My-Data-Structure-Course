/*
 * @Author: 孔潇
 * @Date: 2020-07-01 22:19:42
 * @LastEditTime: 2020-07-01 22:19:43
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Service\TransLate.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Service;

//import app.DATASTRUCTURE.HuffmanCoding.Entity.TreeNode;
import app.DATASTRUCTURE.Test.node;

public class TransLate {

    public static String fanyi(String a, node e) {
        String temp = "";
        char[] s = a.toCharArray();
        node n = e;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                n = n.left;
                if (n.left == null && n.right == null) {
                    StringBuilder ss = new StringBuilder();
                    ss.append(n.c);
                    temp = temp + ss.toString();
                    // System.out.print(n.c);
                    n = e;
                }
            } else {
                n = n.right;
                if (n.left == null && n.right == null) {
                    // System.out.print(n.c);
                    StringBuilder ss = new StringBuilder();
                    ss.append(n.c);
                    temp = temp + ss.toString();
                    n = e;
                }
            }
        }
        return temp;

    }

}
