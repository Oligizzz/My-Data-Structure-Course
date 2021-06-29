/*
 * @Author: 孔潇
 * @Date: 2020-04-26 13:13:09
 * @LastEditTime: 2020-04-26 13:15:02
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\TreeTest\findparefnt.c
 */
typedef struct node{datatype data;
struct node*lchild,*rchild;
} bitree;

bitree*q[20];

int r=0,f=0,flag=0;

void preorder(bitree*bt,char x)

{

if(bt!=0&&flag==0)

  if(bt->data==x){
      flag=1;
      return;
      }

  else{
      r=(r+1)%20;
      q[r]=bt;
      preorder(bt->lchild,x);

    preorder(bt->rchild,x);}

void parent(bitree*bt,char x)

{

int i;

preorder(bt,x);

for(i=f+1;i<=r;i++)if(q[i]->lcild->data==x||q[i]->rchild->data)break;

if(flag==0)printf("not foundx");

else if(i<=r)printf("%c",bt->data);

else printf("not parent")

}

}