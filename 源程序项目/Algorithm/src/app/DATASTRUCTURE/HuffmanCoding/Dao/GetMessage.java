/*
 * @Author: 孔潇
 * @Date: 2020-07-01 22:15:12
 * @LastEditTime: 2020-07-01 22:16:12
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Dao\GetMessage.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMessage {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 输入明文建立密码树
    public void getMessageForConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        setMessage(str);
    }

    // 读取文件建立密码树
    public void getMessageForFile(String FileName) {
        String pathName = FileName;
        String str = "";
        try (FileReader reader = new FileReader(pathName); BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                line += line;
            }
            str = line;

        } catch (IOException e) {
            e.printStackTrace();
        }
        setMessage(str);
    }
}