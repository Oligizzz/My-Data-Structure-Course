/*
 * @Author: 孔潇
 * @Date: 2020-06-17 20:15:52
 * @LastEditTime: 2020-06-17 20:15:53
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\期末考试\addTril.cpp
 */ 
#include<stdio.h>
#include<stdlib.h>
#define  MAXSIZE 1000
typedef struct Triple
{
    int e;
    int row,col;
}Triple;
 
typedef struct TSMatrix
{
    Triple data[MAXSIZE+1];
    int m,n,len;
}TSMatrix;
TSMatrix t1;
TSMatrix t2;
void InputMatrix(TSMatrix *t1,TSMatrix *t2)
{
 
    scanf("%d%d",&t1->len,&t2->len);
    int i;
    for(i=1;i<=t1->len;i++)
    {
        scanf("%d%d%d",&t1->data[i].row,&t1->data[i].col,&t1->data[i].e);
    }
 
   for(i=1;i<=t2->len;i++)
    {
        scanf("%d%d%d",&t2->data[i].row,&t2->data[i].col,&t2->data[i].e);
    }
}
 
void Output(TSMatrix t)
{
 
    int i;
    for(i=1;i<=t.len;i++)
    {
         printf("%d %d %d\n",t.data[i].row,t.data[i].col,t.data[i].e);
    }
}
void AddMastrix(TSMatrix a,TSMatrix b,TSMatrix *c)
{
    int i=1,j=1,k=1;
    c->m=a.m; c->n=a.n;
    while (i<=a.len && j<= b.len)
    {
        if (a.data[i].row < b.data[j].row)
        {
            while (j <= b.len && i<= a.len && a.data[i].row < b.data[j].row)
            {
                c->data[k] = a.data[i];
                i++;
                k++;
            }
        }
      else  if (a.data[i].row > b.data[j].row)
        {
            while (j <= b.len && i <= a.len && a.data[i].row > b.data[j].row)
            {
 
                c->data[k] = b.data[j];
                j++;
                k++;
            }
        }
      else if (a.data[i].row == b.data[j].row)
        {
            if (a.data[i].col < b.data[j].col)
            {
                c->data[k] = a.data[i];
                i++;
                k++;
            }
            else  if (a.data[i].col > b.data[j].col)
            {
                c->data[k] = b.data[j];
                j++;
                k++;
            }
            else if (a.data[i].col == b.data[j].col)
                {
                if (a.data[i].e + b.data[j].e != 0)
                {
                    c->data[k].row=a.data[i].row;
                    c->data[k].col=a.data[i].col;
                    c->data[k].e=a.data[i].e+b.data[j].e;
                    k++;
                }
                j++;
                i++;
                }
        }
  }
    while (i<=a.len)
    {
        c->data[k]=a.data[i];
        k++;
        i++;
    }
    while (j<= b.len)
    {
        c->data[k]=b.data[j];
        k++;
        j++;
    }
    c->len=k-1;
}
int main()
{
    TSMatrix a,b,c;
    InputMatrix(&a,&b);
    AddMastrix(a,b,&c);
    Output(c);
    return 0;
}
