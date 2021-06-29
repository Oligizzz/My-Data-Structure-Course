'''
@Author: 孔潇
@Date: 2020-06-10 11:34:04
@LastEditTime: 2020-06-10 14:45:34
@Description:  
@FilePath: \Data Structure\Algorithm\src\app\test.py
'''
N = eval(input("请问在第几天想吃的时候发现只有一个了？"))
n = 1
for i in range(N-1, 0, -1):
    n = (n+1) << 1
print("贪心的猴子儿第一天摘了{}个桃子。".format(n))
