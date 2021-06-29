package app.DATASTRUCTURE.Tree.OrdTree.CHAIN;


//树的链式存储(二)
//双亲孩子存储parent_child

//树结构
public class parent_child extends OrdTree__Chain {

   CTBox nodes [];     //结点数组
   int r;              //根的下标
   int n ;             //结点数量
}

//孩子结点
class CTNode {
    int child;         //孩子结点的下标
    CTNode next ;      //指向下一个孩子的指针
}


//表头结构
class CTBox {
    int data;           // 数据域
    int parent;         // 双亲结点的下标
    CTNode first_child; // 指向第一个孩子
}