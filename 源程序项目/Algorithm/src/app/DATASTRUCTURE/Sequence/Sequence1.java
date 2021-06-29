/*
 * @Author: 孔潇
 * @Date: 2020-05-23 20:39:09
 * @LastEditTime: 2020-05-23 20:45:03
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Sequence\Sequence1.java
 */
package app.DATASTRUCTURE.Sequence;

public class Sequence1 {

    public void ContSort(T[] a, T[] b, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0,count = 0; j < n; j++) {
                if (a[j].key<a[i].key) {
                    count++;
                }
                b[count] = a[i];
            }

        }
    }

}

class T {
    int key;
}