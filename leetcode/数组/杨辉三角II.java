package 数组;

import java.awt.List;
import java.util.ArrayList;

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

输入: 3
输出: [1,3,3,1]
 */
//杨辉三角形的第n行的m个数可表示为 C(n-1,m-1).
public class 杨辉三角II {
	public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> resultList=new ArrayList<Integer>(rowIndex+1);
        long nk = 1;
        for(int i=0;i<=rowIndex;i++) {
        		resultList.add((int)nk);
        		nk=nk*(rowIndex-i)/(i+1);
        	}
        return resultList;
    }
	public static void main(String[] args) {
		int rowIndex=3;
		System.out.println(getRow(rowIndex));
		

	}

}
