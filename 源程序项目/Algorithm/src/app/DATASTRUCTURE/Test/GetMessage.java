/*
 * @Author: 孔潇
 * @Date: 2020-07-02 13:44:55
 * @LastEditTime: 2020-07-02 13:45:25
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Test\GetMessage.java
 */
package app.DATASTRUCTURE.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetMessage {
    public String getMessageForFile(String FileName) {
        String pathName = FileName;
        String str = "";
        try (FileReader reader = new FileReader(pathName); BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                str = str + line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
