'''
@Author: 孔潇
@Date: 2020-06-09 14:07:13
@LastEditTime: 2020-06-09 14:29:22
@Description:  
@FilePath: \Data Structure\Algorithm\src\app\TreeTest\Monkey.py
'''
N = eval(input("请问在第第几天想吃的时候发现只有一个桃儿了？"))
counts=1
for i in range(0,N-1):
    counts = (counts+1)*2
print("贪心的猴子儿第一天摘了{}个桃子".format(counts))

def f(n):
    if n == 1:
        return 1
    else:
        return (f(n-1)+1)*2
print(f(10))