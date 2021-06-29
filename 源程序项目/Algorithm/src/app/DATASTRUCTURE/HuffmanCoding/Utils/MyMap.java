/*
 * @Author: 孔潇
 * @Date: 2020-06-29 15:08:43
 * @LastEditTime: 2020-06-29 16:19:36
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Utils\MyMap.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Utils;

/**
 * Map接口
 * 
 * @param <K>
 * @param <V>
 */
public interface MyMap<K, V> {

  // 向Map中插入值
  public V put(K k, V v);

  // 根据key获取hashMap中的值
  public V get(K k);

  // 获得Map中元素的个数
  public int size();

  // 获取Map中，键值对的对象
  interface Entry<K, V> {
    K getKey();

    V getValue();

    V setValue(V v);

  }
}
