package 动态规划;

import java.lang.instrument.IllegalClassFormatException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
题目：一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3 
输入描述: 
输入为两行。 
第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 
第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。

输出描述: 
所有连续子数组中和最大的值。

输入例子: 
3 
-1 2 1 
输出例子: 
3 
*/
public class 连续最大和 {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int[] arr = {6,-3,-2,7,-15,1,2,2};
		System.out.println(maxSubSum(arr));
		
	}
	
	public static Map<String, Integer> maxSubSum(int[] arr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int maxSum=0; //存储连续子元素和的最大值,赋初值为0
		int curSum=0;  //存储当前连续n项的和
		int newbegin=0; //记录开始位置
		int newend=0;  //记录结束位置
		int tempbegin=0;//记录暂存开始位置
		for(int i=0;i<arr.length;i++) {
			curSum+=arr[i];  
			if(curSum<0) {//如果加之和为0或负值，则直接清零
				tempbegin=i+1;
				newend=i+1;
				curSum=0;
			}
			else {  //如果之前所见之和为正，则继续加
				if(curSum>maxSum) { //每次改变curSum的值都有与maxSum进行比较
					newbegin=tempbegin;
					newend=i+1;
					maxSum=curSum;
			}
			
			}
		}
		map.put("maxsum", maxSum);
		map.put("start", newbegin);
		map.put("end", newend);
		return map;
//		System.out.println("maxsum="+maxSum+",start:"+newbegin+",end="+newend);
	}

}
