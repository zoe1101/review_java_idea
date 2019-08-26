package 字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

 */
public class 最大数 {
	public static String largestNumber(int[] nums) {
       List<String> dataList=new ArrayList<String>(); //存的是比较结果，按优先级排列
 	   for(int num:nums){
           dataList.add(String.valueOf(num));
       }
//    	定义一个排序方法，从高到低循环比较两个整数的每一位，大的排在前面，即按照字典序的逆序排序
    	Collections.sort(dataList,new Comparator<String>() {
    		public int compare(String s2,String s1){
    			String a=s1+s2;
    	        String b=s2+s1;
    	        return a.compareTo(b); //s1+s2的组合和组合s2+s1的大小关系
    		}
		});

	   StringBuffer sb = new StringBuffer("");
	   for(String data:dataList){
           sb.append(data);
       }
	   String result=sb.toString();
	   //检查结果格式，假如全是0
       int index=0;
       while(index<result.length()){
           if(result.charAt(index)!='0'){
               break;
           }
           index++;
       }
       result=result.substring(index,result.length());
       if(result.equals("")){
           result="0";
       }
       return result;
    }
	 public static void main(String[] args) {
		int[] nums= {10,2};
		System.out.println(largestNumber(nums));
	}
}
