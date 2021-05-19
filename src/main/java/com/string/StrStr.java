package com.string;

/**
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
          if("".equals(needle)){
              return 0;
          }

          char[] targetChar = haystack.toCharArray();
          char[] resultChar = needle.toCharArray();

          for(int i=0;i < targetChar.length;i++){
              if(targetChar[i] == resultChar[0]){
                  boolean fund = true;
                  for (int j =0;j < resultChar.length ;j++){
                      if(i+j >= targetChar.length || targetChar[i+j] != resultChar[j]){
                          fund = false;
                          break;
                      }
                  }
                  if(fund){
                      return i;
                  }
              }
          }
          return -1;
    }

    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }


}
