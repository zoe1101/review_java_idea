package 字符串;

import java.util.Arrays;

import test.test;
/**
 * 单词字符串逆序，单词顺序逆序
 * @author zoe
 *
 */
public class 翻转字符串 {
	public static void rotateWord(char[] chas) {
		if(chas==null ||chas.length==0) {
			return ;
		}
		reverse(chas, 0, chas.length-1);
		int left=-1;
		int right=-1;
		for(int i=0;i<chas.length;i++) {
			if(chas[i]!=' ') {
				left= i==0 || chas[i-1]==' '?i:left;
				right=i==chas.length-1 || chas[i+1]==' '?i:right;
			}
			if(left!=-1 && right!=-1) {
				reverse(chas, left, right);
				left=-1;
				right=-1;
			}
		}
	}
	/**
	 * 字符串逆序
	 * @param chas
	 * @param start
	 * @param end
	 */
	public static void reverse (char[] chas,int start,int end) {
		char tmp=0;
		while (start<end) {
			tmp=chas[start];
			chas[start]=chas[end];
			chas[end]=tmp;
			start++;
			end--;
		}
	}
/**
 * 字符串部分移动，前size个字符移动到字符串后半部分
 * @param chas
 * @param size
 */
	public static void rotateString(char[] chas,int size) {
		if(chas==null ||size<=0|| size>=chas.length) {
			return ;
		}
		
		reverse(chas, 0, size-1); //前半部分逆序
		reverse(chas, size, chas.length-1);//后半部分逆序
		reverse(chas, 0, chas.length-1);//整体逆序
	}
	
	/**
	 * 字符串部分移动，前size个字符移动到字符串后半部分
	 * @param chas
	 * @param size
	 */
	public static void rotateString2(char[] chas,int size) {
		if(chas==null ||size<=0|| size>=chas.length) {
			return ;
		}
		
		int start=0;
		int end=chas.length-1;
		int lpart=size; //左边字符串长度
		int rpart=chas.length-size; //右边字符串长度
		int exsize=Math.min(lpart, rpart); //交换部分的长度
		int d=lpart-rpart; //左边和右边字符串的长度差
		while (true) {
			exchange(chas, start, end, exsize);
			if(d==0) { ////左右字符数相等,交换后停止循环
				break;
			}else if(d>0) { //左边字符多余右边,右边的移到左边的字符无需再移动,即前exsize个元素已定
				start+=exsize; //交换移动的起始位置向右移动exsize
				lpart=d;
			}else {//左边字符少于右边,左边的移到右边的字符无需再移动,即后exsize个元素已定
				end-=exsize; //交换移动的结束位置向左移动exsize
				rpart=-d;
			}
			exsize=Math.min(lpart, rpart);
			d=lpart-rpart;
		}
	}
	public static void exchange(char[] chas, int start,int end, int size) {
		int i=end-size+1;
		char tmp=0;
		while (size--!=0) {
			tmp=chas[start];
			chas[start]=chas[i];
			chas[i]=tmp;
			start++;
			i++;
		}
	}
	
	public static void main(String[] args) {
		char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
				'i', 'g' };
		System.out.println(String.valueOf(chas1));
		rotateWord(chas1);
		System.out.println(String.valueOf(chas1));

		char[] chas2 = { '1', '2', '3', '4', '5', 'A', 'B', 'C' };
		System.out.println(String.valueOf(chas2));
		rotateString(chas2, 5);
		System.out.println(String.valueOf(chas2));
		rotateString2(chas2, 5);
		System.out.println(String.valueOf(chas2));

	}

}
