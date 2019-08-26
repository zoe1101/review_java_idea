package 数组;
/*
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
 */
//解题思路；大数加法，相当于列竖式计算
import java.awt.List;
import java.util.ArrayList;

public class 数组形式的整数加法 {
	public static ArrayList<Integer> addToArrayForm(int[] A, int K) {
        int carry=0;//进位标志
        int t;//用于暂存数据
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=A.length-1;i>=0;i--,K/=10) {
        	t=A[i]+K%10+carry;
        	carry=t/10;//判断是否需要进位
        	list.add(0,t%10);//将余数存起来
        }
        //如果K比A的位数多，则继续进行加法计算
        while(K>0) {
        	t=K%10+carry;
        	carry=t/10; //判断是否需要进位
        	list.add(0,t%10);
        	K/=10;
        }
        if(carry>0) {//对进位后最高位是1的情况进行处理
        	list.add(0,carry);
        }
        return list;
    }

	public static void main(String[] args) {
		int[] A= {9,9,9,9,9,9,9,9,9,9};
		int K=101;
		System.out.println(addToArrayForm(A,K));

	}

}
