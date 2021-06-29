/*
 * @Author: 孔潇
 * @Date: 2020-07-01 14:16:11
 * @LastEditTime: 2020-07-01 15:17:56
 * @Description:  自制排序器
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\Sort\sortForArrayList.java
 */
package app.DATASTRUCTURE.HuffmanCoding.Sort;

import app.DATASTRUCTURE.HuffmanCoding.Entity.TreeNode;
import app.DATASTRUCTURE.HuffmanCoding.Utils.MyArrayList;

public class sortForArrayList {

    public static void sort(MyArrayList<TreeNode> list, int lo, int hi) {
        // 前提
        assert list != null && lo >= 0 && lo <= hi && hi <= list.size();

        // 待排序list长度
        int nRemaining = hi - lo;

        if (nRemaining < 2)
            return; // 大小为0和1的数组总是排序的

        int initRunLen = countRunAndMakeAscending(list, lo, hi);
        binarySort(list, lo, hi, lo + initRunLen);
    }

    // 找到前端有序序列
    private static <T> int countRunAndMakeAscending(MyArrayList<TreeNode> list, int lo, int hi) {
        // 前提断言
        assert lo < hi;

        int runHi = lo + 1;
        if (runHi == hi)
            return 1;

        // 找出最长升序序的子序列，如果降序，倒置之
        if (((TreeNode) list.get(runHi++)).getWeight() - ((TreeNode) list.get(lo)).getWeight() < 0) { // 降序
            while (runHi < hi
                    && ((TreeNode) list.get(runHi)).getWeight() - ((TreeNode) list.get(runHi - 1)).getWeight() < 0)
                runHi++;
            reverseRange(list, lo, runHi);
        } else { // Ascending
            while (runHi < hi
                    && ((TreeNode) list.get(runHi)).getWeight() - ((TreeNode) list.get(runHi - 1)).getWeight() >= 0)
                runHi++;
        }

        return runHi - lo;
    }

    /**
     * @Author: kongxiao
     * @Description:翻转
     * @param a  指定数组
     * @param lo 这段范围的起始位置
     * @param hi 这段范围的终点位置的后一个位置
     * @return:
     */
    private static void reverseRange(MyArrayList<TreeNode> a, int lo, int hi) {
        hi--;
        while (lo < hi) {
            TreeNode t = (TreeNode) a.get(lo);
            a.set(lo++, (TreeNode) a.get(hi));
            a.set(hi--, t);
        }
    }

    // 二分插入
    private static <T> void binarySort(MyArrayList<TreeNode> a, int lo, int hi, int start) {
        assert lo <= start && start <= hi;
        // 如果start 从起点开始，做下预处理；也就是原本就是无序的。
        if (start == lo)
            start++;
        // 从start位置开始，对后面的所有元素排序
        for (; start < hi; start++) {
            // pivot 代表正在参与排序的值，
            TreeNode pivot = (TreeNode) a.get(start);

            // Set left (and right) to the index where a[start] (pivot) belongs
            // 把pivot应当插入的设置的边界设置为left和right
            int left = lo;
            int right = start;
            assert left <= right;

            /*
             * 保证的逻辑: pivot >= all in [lo, left). pivot < all in [right, start).
             */
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot.getWeight() - ((TreeNode) a.get(mid)).getWeight() < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            assert left == right;

            /**
             * 此时，仍然能保证: pivot >= [lo, left) && pivot < [left,start)
             * 所以，pivot的值应当在left所在的位置，然后需要把[left,start)范围内的内容整体右移一位
             * 腾出空间。如果pivot与区间中的某个值相等，left指正会指向重复的值的后一位， 所以这里的排序是稳定的。
             */
            int n = start - left; // 需要移动的范围的长度

            // switch语句是一条小优化，1-2个元素的移动就不需要System.arraycopy了。
            // （这代码写的真是简洁，switch原来可以这样用）
            switch (n) {
                case 2:
                    a.set(left + 2, (TreeNode) a.get(left + 1));
                case 1:
                    a.set(left + 1, (TreeNode) a.get(left));
                    break;
                default:
                    System.arraycopy(a.toArray(), left, a.toArray(), left + 1, n);
            }
            // 移动过之后，把pivot的值放到应该插入的位置，就是left的位置了
            a.set(left, pivot);
        }
    }

}
