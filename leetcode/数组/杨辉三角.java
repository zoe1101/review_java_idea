package 数组;

import java.util.ArrayList; //ArrayList是一个泛型类。

/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

//方法: 动态规划
//用于构造杨辉三角的迭代方法可以归类为动态规划, 因为我们需要基于前一行来构造每一行。
public class 杨辉三角 {

	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		if(numRows==0) {//0行的情况
			return list;
		}
		ArrayList<Integer> firstrow=new ArrayList<Integer>();
		firstrow.add(1);
		list.add(firstrow);//第一行总是[1] 
		
		for(int i=1;i<numRows;i++) {
			ArrayList<Integer> rowlist=new ArrayList<Integer>();
			ArrayList<Integer> prerowlist=list.get(i-1);//获取上一行的元素
			rowlist.add(1);///每一行的第一个元素总是1;
			for(int j=1;j<i;j++) {
				rowlist.add(prerowlist.get(j-1)+prerowlist.get(j));
			}
			rowlist.add(1);//每一行的最后一个元素总是1;
			list.add(rowlist);
		}
		return list;
        
    }
	public static void main(String[] args) {
		int  numRows=5;
		System.out.println(generate(numRows));

	}

}
