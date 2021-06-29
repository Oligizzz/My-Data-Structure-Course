/*
 * @Author: 孔潇
 * @Date: 2020-06-29 13:27:52
 * @LastEditTime: 2020-06-29 13:35:43
 * @Description:  自己实现的Arraylist
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Collections\MyArrayList.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Utils;

public class MyArrayList<T> {

    // 成员变量
    private Object a[]; // 一维数组
    // transient Object[] elementData;
    private int size; // 表中元素个数

    // 构造器
    public MyArrayList() {
        a = new Object[0];
        this.size = a.length;
    }

    // 获取容器中元素个数
    public int size() {
        return this.size;
    }

    // 判断容器是否为空
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能: 添加元素
     * 
     * @param value 接收的新元素
     */
    public void add(T value) {
        size++; // 元素个数增加一
        Object[] temp = new Object[size];
        // 将a数组的所有元素复制到temp
        System.arraycopy(a, 0, temp, 0, a.length);
        temp[size - 1] = value; // 新元素放到最后面
        a = temp; // 让a记住新数组。
    }

    /**
     * @function 删除元素
     * @param loc 元素的索引号
     * @return 是否删除成功
     */
    public boolean remove(int loc) {
        if (loc < 0 || loc >= size) {
            return false;
        } else {
            size--;
            Object[] temp = new Object[size];
            // loc之前的所有元素复制到temp中
            System.arraycopy(a, 0, temp, 0, loc);
            // loc之后的所有元素复制到temp中
            System.arraycopy(a, loc + 1, temp, loc, a.length - loc - 1);
            a = temp;
            return true;
        }
    }

    public Object get(int loc) {
        // 检查下标是否越界
        if (loc < 0 || loc >= size) {
            return false;
        } else {
            return a[loc];
        }

    }

    /**
     * @function 修改指定位置上的元素值。
     * @param loc   位置编号
     * @param value 新值
     * @return 是否修改成功
     */
    public boolean set(int loc, T value) {
        if (loc < 0 || loc >= size) {
            return false;
        } else {
            a[loc] = value;
            return true;
        }
    }

    /**
     * @function 插入新元素
     * @param loc   插入的位置
     * @param value 新元素
     * @return 是否插入成功
     */
    public boolean insert(int loc, T value) {
        if (loc < 0 || loc > size) {
            return false;
        } else if (loc == size) {
            this.add(value);
            return true;
        } else {
            size++;
            Object[] temp = new Object[size];
            // 复制a的loc之前的所有元素
            System.arraycopy(a, 0, temp, 0, loc);
            // 复制之后的
            System.arraycopy(a, loc, temp, loc + 1, a.length - loc);
            // 新元素入位
            temp[loc] = value;
            a = temp;
            return true;
        }
    }

    // 以字符串方式反馈所有元素
    public String toString() {
        StringBuilder vs = new StringBuilder();
        vs.append("[");
        for (int i = 0; i < size - 1; i++) {
            vs.append(a[i]).append(", ");
        }
        if (size != 0) {
            vs.append(a[size - 1]).append("]");
        } else {
            vs.append("]");
        }
        return vs.toString();
    }

    public Object[] toArray() {
        Object[] temp = new Object[size];
        // 将a数组的所有元素复制到temp
        System.arraycopy(a, 0, temp, 0, size);
        return temp;
    }

}