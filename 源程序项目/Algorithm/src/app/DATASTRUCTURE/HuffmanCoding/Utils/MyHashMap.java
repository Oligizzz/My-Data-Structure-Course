/*
 * @Author: 孔潇
 * @Date: 2020-06-29 15:11:29
 * @LastEditTime: 2020-06-29 16:39:32
 * @Description:  自定义HashMap（数组+链表）
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Utils\MyHashMap.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    // 数据存储的结构==>数组+链表
    Node<K, V>[] array = null;

    // 哈希桶的长度,数组初始化的长度
    private static int defaultLength = 16;

    
    //扩容因子,数组界定的一个存储阈值, 当数组元素个数达到整个数组的75%的时候,触发扩容机制)
    private static double factor = 0.75D;

    // hashMap中当前元素个数
    private int size;

    // put元素方法
    @SuppressWarnings("unchecked")
    @Override
    public V put(K k, V v) {

        //1、数组初始化
        if (array == null) {
            array = new Node[defaultLength];
        }

        // 2.通过hash函数映射到数组下标
        int index = position(k, defaultLength);

        // 扩容机制：当元素的个数size 大于 桶的尺寸*加载因子
        if (size > defaultLength * factor) {
            resize();
        }

        // 3.先找到桶
        Node<K, V> node = array[index];

        // 4、再判断桶里面有没有元素
        if (node == null) {
            // 4.1、如果桶是空的,直接新建该链表并将值放入桶中
            array[index] = new Node<K, V>(k, v, null);
            // 4.2、元素的个数加自增1
            size++;

        } else {//桶里面有元素
            //键值相等
            if (k.equals(node.getKey()) || k == node.getKey()) {
                //覆盖旧的value，并返回旧的value
                return node.setValue(v);
            } else {
                array[index] = new Node<K, V>(k, v, node);
                size++;
            }
        }

        return null;
    }

    // 扩容,并且重新排列元素
    private void resize() {
        // 翻倍扩容
        // 1.创建新的array临时变量,相当于defaultlength*2
        @SuppressWarnings("unchecked")
        Node<K, V>[] temp = new Node[defaultLength << 1];

        // 2.重新计算散列值，插入到新的array中去。 code=key % defaultLength ==> code=key %
        // defaultLength*2
        Node<K, V> node = null;

        for (int i = 0; i < array.length; i++) {
            node = array[i];
            while (node != null) {
                // 重新散列
                int index = position(node.getKey(), temp.length);
                // 插入链表的头部
                Node<K, V> next = node.next;
                // 3
                node.next = temp[index];
                // 1
                temp[index] = node;
                // 2
                node = next;

            }
        }

        // 3.替换掉旧的array
        array = temp;
        // 更新默认的扩容因子的值
        defaultLength = temp.length;
        temp = null;

    }

    // 计算位置
    private int position(K k, int length) {
        int code = k.hashCode();

        // 取模算法
        return code % (length - 1);

        // 求与算法
        // return code & (defaultLength-1);
    }

    /**
     * 用K获取hashMap 的K对应的值
     */
    @Override
    public V get(K k) {
        if (array != null) {
            int index = position(k, defaultLength);
            Node<K, V> node = array[index];
            // 遍历链表
            while (node != null) {
                // 如果key值相同返回value
                if (node.getKey() == k) {
                    return node.getValue();
                } else {
                    // 如果key值不同则调到下一个元素
                    node = node.next;
                }
            }
        }

        return null;
    }

    /**
     * 获取hashMap元素个数
     */
    @Override
    public int size() {

        return size;
    }

    // Map节点类
    static class Node<K, V> implements Entry<K, V> {
        K key;
        V value;
        // 表示下一个节点
        Node<K, V> next;

        // 构造一个包含当前节点和下一个节点的链表
        public Node(K key, V value, Node<K, V> next) {
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 链表的get和set方法
         */
        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            V oldValue = this.value;
            this.value = v;
            return oldValue;
        }

    }

    // 测试方法
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        if (array != null) {
            Node<K, V> node = null;
            for (int i = 0; i < array.length; i++) {
                node = array[i];
            
                // 遍历链表
                while (node != null) {
                    set.add(node.getKey());
                    if (node.next != null) {
                        node = node.next;
                    } else {
                        // 到尾部元素
                        node = null;
                    }
                }
            }

        }
        return set;
    }
}