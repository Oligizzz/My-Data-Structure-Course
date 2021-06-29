/*
 * @Author: 孔潇
 * @Date: 2020-05-02 19:37:33
 * @LastEditTime: 2020-05-02 19:37:34
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\GraphTest\Test.cpp
 */
#include <stdio.h>
#include <malloc.h>
#include <stdbool.h>

#define INF     32767               //定义∞
#define MAXV    100                 //最大顶点个数

typedef char InfoType;
/*-------------------------以下定义邻接矩阵类型---------------------------*/
typedef struct
{
    int no;                         //顶点编号
    InfoType info;                  //顶点信息
}VertexType;                        //顶点类型

typedef struct
{
    int edges[MAXV][MAXV];          //邻接矩阵数组(用一个二维数组存放顶点间关系(边或弧)的数据)
    int n;                          //顶点数
    int e;                          //边数
    VertexType vexs[MAXV];          //存放顶点信息(用一个一维数组存放图中所有顶点数据)
}MatGraph;                          //完整的图邻接矩阵类型

//邻接表表示法-将每个顶点的邻接点串成一个单链表
/*-----------以下定义邻接表类型--------------*/
typedef struct ArcNode
{
    int adjvex;                     //该边的邻接点编号
    struct ArcNode *nextarc;        //指向下一条边的指针
    int weight;                     //该边的相关信息,如权值(用整型表示)
}ArcNode;                           //边结点类型

typedef struct VNode
{
    InfoType info;                  //顶点其他信息
    int cnt;                        //存放顶点入度,仅用于拓扑排序
    ArcNode *firstarc;              //指向第一条边
}VNode;                             //邻接表结点类型

typedef struct
{
    VNode adjlist[MAXV];            //邻接表头结点数组
    int n;                          //图中顶点数
    int e;                          //图中边数
}AdjGraph;                          //完整的图邻接表类型

/*-------------------------邻接矩阵的基本运算算法---------------------------*/
/*------------由边数组A、顶点数n和边数e创建图的邻接矩阵g--------------------*/
void CreateMat(MatGraph &g, int A[MAXV][MAXV], int n, int e)
{
    int i, j;

    g.n = n;
    g.e = e;
    for(i = 0; i < g.n; i++)
        for(j = 0; j < g.n; j++)
            g.edges[i][j] = A[i][j];
}

/*------------输出邻接矩阵g--------------------*/
void DispMat(MatGraph g)
{
    int i, j;

    for(i = 0; i < g.n; i++)
    {
        for(j = 0; j < g.n; j++)
        {
            if(g.edges[i][j] != INF)
                printf("%4d", g.edges[i][j]);
            else
                printf("%4s", "∞");
        }
        printf("\n");
    }
}

/*-------------------------邻接表的基本运算算法---------------------------*/
/*-------------------由边数组A、顶点数n和边数e创建图的邻接表G--------------------*/
void CreateAdj(AdjGraph *&G, int A[MAXV][MAXV], int n, int e)
{
    int i, j;
    ArcNode *p;

    G = (AdjGraph *)malloc(sizeof(AdjGraph));
    for(i = 0; i < n; i++)                              //给邻接表中所有头结点的指针域置初值NULL
    {
        G->adjlist[i].firstarc = NULL;
    }

    for(i = 0; i < n; i++)                              //检查邻接矩阵中的每个元素
    {
        for(j = n - 1; j >= 0; j--)
        {
            if(A[i][j] != 0 && A[i][j] != INF)          //存在一条边
            {
                p = (ArcNode *)malloc(sizeof(ArcNode)); //创建一个结点p
                p->adjvex = j;                          //邻接点编号
                p->weight = A[i][j];                    //边的权重
                p->nextarc = G->adjlist[i].firstarc;    //采用头插法插入结点p
                G->adjlist[i].firstarc = p;
            }
        }
    }
    G->n = n;
    G->e = e;
}

/*-------------------输出邻接表G--------------------*/
void DispAdj(AdjGraph *G)
{
    ArcNode *p;

    for(int i = 0; i < G->n; i++)
    {
        p = G->adjlist[i].firstarc;
        printf("顶点%d: ", i);
        while(p != NULL)
        {
            printf("%3d[%d]->", p->adjvex, p->weight);  //邻接点编号[权重]
            p = p->nextarc;
        }
        printf("∧\n");
    }
}

/*-------------------销毁图的邻接表G--------------------*/
void DestroyAdj(AdjGraph *&G)
{
    ArcNode *pre, *p;

    for(int i = 0; i < G->n; i++)
    {
        pre = G->adjlist[i].firstarc;                   //pre指向第i个单链表的首结点
        if(pre != NULL)
        {
            p = pre->nextarc;
            while(p != NULL)                            //释放第i个单链表的所有边结点
            {
                free(pre);
                pre = p;
                p = p->nextarc;
            }
            free(pre);
        }
    }
    free(G);                                            //释放头结点数组
}

/*--------------全局变量-----------------*/
int visited[MAXV];
int n;                          //必经点个数
int m;                          //必避点个数
int V1[MAXV];                   //必经点集合
int V2[MAXV];                   //必避点集合
int cnt = 0;

/*----------------判断条件----------------------*/
static bool cond(int path[], int d)
{
    int flag1 = 0, f1, flag2 = 0, f2, i, j;

    //判断路径中是否有必经点
    for(i = 0; i < n; i++)
    {
        f1 = 1;
        for(j = 0; j <= d; j++)
        {
            if(path[j] == V1[i])
            {
                f1 = 0;
                break;
            }
        }
        flag1 += f1;
    }

    //判断路径中是否有必避点
    for(i = 0; i < m; i++)
    {
        f2 = 0;
        for(j = 0; j <= d; j++)
        {
            if(path[j] == V2[i])
            {
                f2 = 1;
                break;
            }
        }
        flag2 += f2;
    }

    if(flag1 == 0 && flag2 == 0)    //满足条件返回true
        return true;
    else                            //不满足条件返回false
        return false;
}

/*----------------在图G中查找从顶点vi到顶点vj的满足条件的路径------------------*/
static void trav_path(AdjGraph *G, int vi, int vj, int path[], int d)
{
    int v, i;
    ArcNode *p;

    visited[vi] = 1;
    d++;
    path[d] = vi;
    if(vi == vj && cond(path, d))
    {
        printf("  路径%d: ", ++cnt);
        for(i = 0; i < d; i++)
            printf("%d->", path[i]);
        printf("%d\n", path[i]);
    }
    p = G->adjlist[vi].firstarc;            //找vi的第一个邻接顶点
    while(p != NULL)
    {
        v = p->adjvex;                      //v为vi的邻接顶点
        if(visited[v] == 0)                 //若该顶点未标记访问，则递归访问之
            trav_path(G, v, vj, path, d);
        p = p->nextarc;                     //找vi的下一个邻接顶点
    }
    visited[vi] = 0;                        //取消访问标记，以使该顶点可重新使用
    d--;
}

int main(void)
{
    int u;                      //起点
    int v;                      //终点
    int i;                      //循环变量
    int path[MAXV];
    AdjGraph *G;
    int A[MAXV][MAXV] = {
        {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
    };
    CreateAdj(G, A, 15, 21);   //建立邻接表
    printf("图G的邻接表:\n");
    DispAdj(G);

    for(i = 0; i < MAXV; i++)
        visited[i] = 0;
    printf("输入起点和终点:");
    scanf("%d%d", &u, &v);
    printf("输入必经点个数:");
    scanf("%d", &n);
    printf("输入必经点集合:");
    for(i = 0; i < n; i++)
        scanf("%d", &V1[i]);
    printf("输入必避点个数:");
    scanf("%d", &m);
    printf("输入必避点集合:");
    for(i = 0; i < n; i++)
        scanf("%d", &V2[i]);
    printf("\n所有的探宝路径如下:\n");
    trav_path(G, u, v, path, -1);
    DestroyAdj(G);

    return 0;
}
————————————————
版权声明：本文为CSDN博主「静能生悟」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/xiezhi123456/article/details/89040319