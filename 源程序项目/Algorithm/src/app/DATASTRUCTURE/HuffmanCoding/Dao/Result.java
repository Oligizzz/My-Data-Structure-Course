/*
 * @Author: 孔潇
 * @Date: 2020-07-02 14:37:48
 * @LastEditTime: 2020-07-02 14:37:49
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Dao\Result.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Dao;

public class Result {

    String resul = "";

    /**
     * @return res
     */

    public Result() {
    };

    public String getRes() {
        return resul;
    }

    /**
     * @param res 要设置的 res
     */
    public void setRes(String res) {
        this.resul = res;
    }

    public void add(String res) {
        this.resul = resul + res;
    }
}
