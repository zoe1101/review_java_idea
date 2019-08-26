package src;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author zoe
 *
 */
public class 和为S的两个数字 {
//左右夹逼的方法。a+b=sum,a和b越远乘积越小
//因为数组是递增排序,所以一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况.
//	若ai + aj == sum，就是答案（相差越远乘积越小）
//	若ai + aj > sum，说明 aj 太大了，j —
//	若ai + aj < sum，说明 ai 太小了，i ++
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(array==null || array.length<2) {
        	return res;
        }
        int i=0;
        int j=array.length-1;
        while (i<j) {
			if(array[i]+array[j]==sum) {
				res.add(array[i]);
				res.add(array[j]);
				break;
			}else if (array[i]+array[j]>sum) {
				j--;
			}else {
				i++;
			}
		}
        return res;
    }
}
