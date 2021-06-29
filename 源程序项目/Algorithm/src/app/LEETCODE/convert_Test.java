/*
 * @Author: 孔潇
 * @Date: 2020-03-30 13:50:46
 * @LastEditTime: 2020-04-18 23:57:50
 * @Description:  
 * @FilePath: \Algorithm\src\app\LEETCODE\convert_Test.java
 */
package app.LEETCODE;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class convert_Test{
    public String convert(String s,int numRows) {
        
        if (s==null ||numRows <=1) return s;// 字符串问题考虑空串

        int count  = Math.min(numRows,s.length());//当串长度不够行数时去串长做行数
        StringBuilder [] row = new StringBuilder[count];//count个变长字符串

        for(int i = 0;i<row.length;i++){//把每个单元设为变长字符串
            row[i] = new StringBuilder();
        }
        

        StringBuilder result  = row[0];
        boolean upDown = false;//判断移动方向
        int j = 0;

        //把s串分别添加
        for (int i = 0;i<s.length();i++) {
            row[j].append(s.charAt(i));

            //方向变换
            if (j == 0||j == numRows-1) {
                upDown = !upDown;
            }
            if (upDown) {
                ++j;
            }else {
                --j;
            }
        }

        //合并数组
        for (int i = 0;i <=row.length-1;i++){
            result.append(row[i]);
        }

        return result.toString();
    }
}