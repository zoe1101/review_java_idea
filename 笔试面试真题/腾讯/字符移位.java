package 腾讯;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

import test.class_A;

/*
小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？

输入例子1:
AkleBiCeilD
输出例子1:
kleieilABCD
 */
public class 字符移位 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		while (scanner.hasNext()) {
			String string=scanner.nextLine();
			int len=string.length();
			int p=len-1;
			char[] s=string.toCharArray();
			for (int i = p; i >= 0; i--){
				char c = s[i];
				if ('A' <= c && c<= 'Z'){
					for (int j = i; j < p; j++)
						s[j] = s[j + 1];
					s[p--]=c;
				}
			}
			for (char c:s) {

				System.out.print(c);
			}
			System.out.println();

		}

	}


}
