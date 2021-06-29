/*
 * @Author: 孔潇
 * @Date: 2020-04-18 21:17:49
 * @LastEditTime: 2020-04-18 21:17:50
 * @Description:  
 * @FilePath: \Algorithm\src\app\aaa.java
 */
package app.TreeTest;

import app.DATASTRUCTURE.Tree.OrdTree.SEQ.*;

public class Layers_1 {

    // log2方法
    public int log2 (int x){
        int i = 0;       //统计x能被2除的次数
        while (x!=1) {   //除到1就停止
            i++;
            x = x/2;     //能除几个2就有几层（除了根节点）
        }
        return i; //返回int值
    }

    public int Level (OrdTree_Seq o,int n,int i){  //参量：树，树的结点总数，位置

        if (i<1||i>n) {   //i的位置不合法
            return 0;
        }
        else {
            //加上第一层
            return log2(i)+1;//调用log2
        }
    }
}