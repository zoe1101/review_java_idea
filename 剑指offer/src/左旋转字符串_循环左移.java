package src;
/*
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class 左旋转字符串_循环左移 {
	
    // 借助反转,分三步
    // 1. 反转要移位的部分
    // 2. 反转其余部分
    // 3. 整体反转
	//也可以把这些步骤反过来,即先整体反转在部分反转
    public static String LeftRotateString(String str,int n) {
        if(n < 0 || n >= str.length()) {
        	return str;
        }
        char[] chas=str.toCharArray();
        reverse(chas, 0, n-1);
        reverse(chas, n, chas.length-1);
        reverse(chas, 0, chas.length-1);
    	return new String(chas);
    }
    private static void reverse(char[] chas,int start,int end) {
		while (start<end) {
			swap(chas, start, end);
			start++;
			end--;
		}
	}
    private static void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
      }
    
	public static void main(String[] args) {
		String string="abcXYZdef";
		System.out.println(string);
		System.out.println(LeftRotateString(string,3));

	}
}

