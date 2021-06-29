/*
 * @Author: 孔潇
 * @Date: 2020-04-25 00:03:37
 * @LastEditTime: 2020-04-25 00:30:25
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\aaa.C
 */
void Findparent(BTNode *b，char x，BTNode *&p){ 
    if (b!=NULL) { 
        if (b->data==x) 
        p=NULL; 
    else if (b->lchild!=NULL && b->lchild->data==x) 
        p=b; 
    else if (b->rchild!=NULL && b->rchild->data==x) 
    p=b; 
    else { 
        Findparent(b->lchild，x，p); 
        if (p==NULL) 
        Findparent(b->rchild，x，p); 
        } 
        } else 
            p=NULL;
        }