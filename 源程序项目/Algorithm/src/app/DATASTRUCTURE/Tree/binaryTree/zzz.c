/*
 * @Author: 孔潇
 * @Date: 2020-04-19 11:35:55
 * @LastEditTime: 2020-04-20 11:06:31
 * @Description:  求二叉树的宽度
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\Tree\binaryTree\zzz.c
 */
 
int width1(BiTree bt)
{
    if(bt == NULL)
        return 0;
    else
    {
        Queue qu; 
        qu.front = qu.rear = -1;    
        BiTree p; 
        BiTree lastnode = bt;         
        BiTree newnode = NULL;       
        int max = 1; 
        int count = 0; 
        qu.data[++qu.rear] = bt;
        while(qu.front != qu.rear)
        {
            p = qu.data[++qu.front];
                if(p->lchild != NULL)
                {
                    qu.data[++qu.rear] = p->lchild;
                    newnode = p->lchild;
                    count++;
                }
                if(p->rchild != NULL)
                {
                    qu.data[++qu.rear] = p->rchild;
                    newnode = p->rchild;
                    count++;
                }
                if(p == lastnode)
                {
                  lastnode = newnode;
                  if(count>max)
                  {
                    max = count;
                    count = 0; 
                  }    
                }
        }
        return max;
    }
}
