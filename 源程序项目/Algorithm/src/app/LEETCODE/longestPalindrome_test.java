package app.LEETCODE;
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class longestPalindrome_test {
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0) return "";                //空串返回空字符串
        int n = s.length();                                   
        boolean [][] Palindrome  = new boolean[n +1][n+1];    //构造矩阵
        String maxStr = "";                                   //最长回文串初始化
        for (int j = 0; j<n+1;j++) {                          //开始判断i，j指针之间的回文串
            for (int i = j; i>=0;i--) {
                if (i == j || i == j-1) {                     //空字符和字符本身都是回文串
                    Palindrome [i][j] = true;
                }else if (s.charAt(i)==s.charAt(j-1)&&Palindrome[i+1][j-1]){ //两个字符相等，并且他们中间的字符串是回文串
                    Palindrome[i][j] = true;
                }
                if (Palindrome[i][j] == true&&i!=j&&maxStr.length()<j-i) {   //舍去空字符，找到最大长度的true值串
                    maxStr = s.substring(i,j);                
                }
            }
        }
        return maxStr;
    }
}