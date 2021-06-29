/*
 * @Author: 孔潇
 * @Date: 2020-07-02 18:17:09
 * @LastEditTime: 2020-07-02 18:17:10
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Entity\codeBook2.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Entity;

import java.util.HashMap;
import java.util.Map;

public class codeBook2 {
    public static Map<Character, String> map = new HashMap<>();

    public void add(char a, String code) {
        map.put(a, code);
    }

    public String getCode(char a) {
        return map.get(a);
    }

    public void add(String result) {
        String[] temp = result.split("\n");
        for (int i = 0; i < temp.length; i++) {
            String[] temp2 = temp[i].split(": ");
            char key = temp2[0].charAt(0);
            String code = temp2[1];
            map.put(key, code);
        }
    }
}
