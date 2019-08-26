package src;

import java.time.chrono.MinguoChronology;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 题目保证输入的数组中没有的相同的数字
输入:
1,2,3,4,5,6,7,0
输出:
7
 * @author zoe
 *
 *采用归并排序的思路
 */
public class 数组中的逆序对 {
	int count=0;
    public int InversePairs(int [] array) {
    	if (array==null || array.length<=1) {
			return 0;
		}
    	mergeUp2Down(array, 0, array.length-1);
    	return count;
    }
    public void mergeUp2Down(int [] a,int start,int end){
    	if(start>=end) {
    		return;
    	}
    	int mid=(start+end)>>1;
    	mergeUp2Down(a, start, mid);
    	mergeUp2Down(a, mid+1, end);
    	merge(a, start, mid, end);
    }
    public void merge(int [] a,int start,int mid,int end){
    	int[] temp=new int[end-start+1];
    	int i=start;//i初始化为前半段第一个数字的下标
    	int j=mid+1;//j初始化为后半段第一个数字的下标
    	int index=0; 
    	while (i<=mid && j<=end) {
			if(a[i]>a[j]) { //逆序对
				temp[index++]=a[j++];
				count+=mid-i+1;
				count=count>1000000007?count%1000000007:count;
			}else { 
				temp[index++]=a[i++];
			}
		}
    	while(i<=mid) {
    		temp[index++]=a[i++];
    	
    	}
        while(j<=end) {
        	temp[index++]=a[j++];
        }
        for(int k=0;k<temp.length;k++) {
        	a[start+k]=temp[k];
        }
    }
}
