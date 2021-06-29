/*
 * @Author: 孔潇
 * @Date: 2020-04-25 13:11:09
 * @LastEditTime: 2020-04-25 13:11:10
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\nullTest.java
 */
package app.TreeTest;

public class nullTest {
    int data;

    public nullTest() {

    }

    public nullTest(int data) {
        this.data = data;
    }

    public nullTest ret(nullTest n) {
        if (n.data < 1) {
            return n;
        }
        return null;

    }

}/*
  * @Author: 孔潇
  * 
  * @Date: 2020-04-25 13:11:09
  * 
  * @LastEditTime: 2020-04-25 13:11:09
  * 
  * @Description:
  * 
  * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\nullTest.java
  */
