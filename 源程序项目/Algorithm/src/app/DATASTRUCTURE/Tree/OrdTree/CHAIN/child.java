package app.DATASTRUCTURE.Tree.OrdTree.CHAIN;


//树的链式存储(一)
//孩子存储法(已知度数)
public class child {
    int data;               //数据域
    child next[]; //指针域

    private child(int MaxSons) {
        this.next = new child[MaxSons];
    }

}