/*
 * @Author: 孔潇
 * @Date: 2020-07-02 18:12:48
 * @LastEditTime: 2020-07-02 18:12:49
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Service\GetCode.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Service;

import app.DATASTRUCTURE.HuffmanCoding.Entity.codeBook2;
import app.DATASTRUCTURE.Test.node;

public class GetCode {

    public String get(codeBook2 book, String message) {
        String code = "";
        char[] a = message.toCharArray();
        for (int i = 0; i < a.length; i++) {
            code = code + codeBook2.map.get(a[i]);
        }
        return code;
    }
}
