/*
 * @Author: 孔潇
 * @Date: 2020-07-02 13:21:22
 * @LastEditTime: 2020-07-02 13:22:49
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Test\CreatTree.java
 */
package app.DATASTRUCTURE.Test;

import java.util.Collections;
import java.util.List;

public class Tree {

  public node creat(String test) {
    List<node> list;
    list = makenode.make(test);
    Collections.sort(list, new compare());
    while (list.size() > 1) {
      node left = list.get(0);
      node right = list.get(1);
      node father = new node();
      father.left = left;
      father.right = right;
      father.value = left.value + right.value;
      list.remove(left);
      list.remove(right);
      list.add(0, father);
      Collections.sort(list, new compare());
    }
    node e = list.get(0);
    return e;
  }

}
