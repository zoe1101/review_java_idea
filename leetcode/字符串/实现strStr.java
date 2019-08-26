package 字符串;
/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 
字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2

 */
//KMP算法
public class 实现strStr {
    public int strStr(String haystack, String needle) {
    	 if(haystack.contains(needle)){
             return haystack.indexOf(needle);
         }else{
             return -1;
         }
    }
}
