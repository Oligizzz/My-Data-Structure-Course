/*
 * @Author: 孔潇
 * @Date: 2020-05-27 11:42:30
 * @LastEditTime: 2020-05-27 17:01:21
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\Experiment\List.java
 */
package app.Experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class List {
    int n;
    Student[] list;

    // 初始化学生表

    // 根据学生个数创建学生表
    public void creat(int n) throws IOException {
        System.out.println("请依次输入学生姓名、ID、成绩（语文、数学、英语、体育）");

        this.list = new Student[100];
        for (int i = 0; i < 100; i++) {
            list[i] = null;
        }

        for (int i = 0; i < n; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str[] = reader.readLine().split(" ");
            Student s = new Student();
            Grade g = new Grade();
            s.name = str[0];
            s.id = Integer.parseInt(str[1]);
            g.chinise = Integer.parseInt(str[2]);
            g.math = Integer.parseInt(str[3]);
            g.english = Integer.parseInt(str[4]);
            g.pe = Integer.parseInt(str[5]);
            g.sum = g.chinise + g.english + g.math + g.pe;
            s.grade = g;
            this.n = n;
            this.list[i] = s;

        }

    }

    // 逐个显示学生表的所有信息
    public void showStudent(List l) {
        if (list != null) {
            System.out.println("学生信息如下：");
            for (int i = 0; i < l.n; i++) {
                System.out.println(
                        "姓名：" + l.list[i].name + "   " + "ID：" + l.list[i].id + "   " + "语文：" + l.list[i].grade.chinise
                                + "   " + "数学：" + l.list[i].grade.math + "   " + "英语：" + l.list[i].grade.english + "   "
                                + "体育：" + l.list[i].grade.pe + "   " + "总分：" + l.list[i].grade.sum + "   ");
            }
        }
    }

    // 给定学生信息，插入到指定位置
    public void insert(List l, Student s, int index) {
        if (index - 1 < 0 || index - 1 >= 100) {
            System.out.println("插入失败，位置不合法！");
        } else {
            for (int i = n; i > index - 1; i--) {
                l.list[i + 1] = l.list[i];
            }
            l.list[index - 1] = s;
            l.n++;
        }
    }

    // 删除指定位置的学生记录
    public void dele(List l, int index) {
        if (l == null) {
            System.out.println("删除失败，空表！");
        } else {
            for (int i = index - 1; i < l.n; i++) {
                l.list[i] = l.list[i + 1];
            }
        }
    }

    // 统计表中学生个数
    public void count(List l) {
        System.out.println("表中学生个数为：" + l.n);
    }

    // 利用直接插入排序或者折半插入排序按照姓名进行排序
    public void seq1(List l) {
        if (l == null) {
            System.out.println("失败，表中没有任何数据！");
        } else {
            for (int i = 2; i < l.n; i++) {
                if (l.list[i - 1].name.compareTo(l.list[i].name) < 0) {
                    l.list[0] = l.list[i];
                    l.list[i] = l.list[i - 1];
                    for (int j = i - 2; l.list[0].name.compareTo(l.list[j].name) < 0; j--) {
                        l.list[j + 1] = l.list[j];
                        l.list[j + 1] = l.list[0];
                    }
                }
            }
        }
        showStudent(l);
    }

    // 利用快速排序按照学号进行排序
    public int seq2(List l, int low, int high) {
        if (l == null) {
            System.out.println("失败，表中没有任何数据！");
            return -1;
        } else {
            l.list[0] = l.list[low];
            int midtempID = l.list[low].id;
            while (low < high) {
                while (low < high && l.list[high].id >= midtempID)
                    --high;
                l.list[low] = l.list[high];
                while (low < high && l.list[high].id < midtempID)
                    ++low;
                l.list[high] = l.list[low];
            }
            l.list[low] = l.list[0];
            return low;
        }
    }

    public void seq2_2(List l, int low, int high) {
        if (low < high) {
            int mid = seq2(l, low, high);
            seq2_2(l, low, mid - 1);
            seq2_2(l, mid + 1, high);
        }
    }

    // 快速排序结果查看
    public void seq3(List l) {
        if (l == null) {
            System.out.println("对不起，现在是空表！");
        }
        Student[] temp = new Student[100];// 暂时存储
        for (int i = 0; i < l.n; i++)
            temp[i] = l.list[i];
        seq2_2(l, 1, l.n);
        System.out.println("排序结果如下：");
        for (int j = 0; j < l.n; j++) {
            System.out.println(j + "  " + "姓名：" + l.list[j].name + "   " + "ID：" + l.list[j].id + "   " + "语文："
                    + l.list[j].grade.chinise + "   " + "数学：" + l.list[j].grade.math + "   " + "英语："
                    + l.list[j].grade.english + "   " + "体育：" + l.list[j].grade.pe + "   " + "总分：" + l.list[j].grade.sum
                    + "   ");
        }

    }

    // 根据学号进行折半查找，要求使用非递归算法实现，成功返回此学生的姓名和成绩
    int Non_Search_Bin(List l, int key) {
        Student[] a = l.list;
        int low = 1, high = l.list.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == a[mid].id)
                return mid;
            else if (key < a[mid].id)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
}