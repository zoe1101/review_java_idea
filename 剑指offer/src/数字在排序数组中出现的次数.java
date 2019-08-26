package src;

import java.lang.annotation.Retention;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author zoe
 *二分查找
 */
public class 数字在排序数组中出现的次数 {
	//需要找到数组中的第一个k和最后一个k出现的位置。
    public static int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length==0) {
			return 0;
		}
       int first=GetFirstK(array, k, 0, array.length-1);
       int last=GetLastK(array, k, 0, array.length-1);
       System.out.println(first+" "+last);
       if(first!=-1 && last!=-1) {
    	   return last-first+1;
       }
        return 0;
    }
    //找到数组中第一个k的下标。如果数组中不存在k，返回-1
    public static int GetFirstK(int[] arr, int k, int start, int end) {
    	while (start<=end) {
    		int mid=(start+end)/2;
        	if(arr[mid]==k) {
        		if((mid>0 && arr[mid-1]!=k) || mid==0) { //第一个k出现的位置
        			return mid;
        		}else {
    				end=mid-1;
    			}
        	}else if (arr[mid]>k) {//k在mid左边
    			end=mid-1;
    		}else {//k在mid右边
    			start=mid+1;
    		}
		}
    	return -1;
    }
    
  //找到数组中最后一个k的下标。如果数组中不存在k，返回-1
    public static int GetLastK(int[] arr, int k, int start, int end) {
    	while (start<=end) {
    		int mid=(start+end)/2;
        	if(arr[mid]==k) {
        		if((mid<arr.length-1 && arr[mid+1]!=k) || mid==arr.length-1) { //最后一个k出现的位置
        			return mid;
        		}else {
    				start=mid+1;
    			}
        	}else if (arr[mid]>k) {//k在mid左边
    			end=mid-1;
    		}else {//k在mid右边
    			start=mid+1;
    		}
		}
    	return -1;
    }
    public static void main(String[] args) {
		int[] arr= {2,3,4,5,6,6,6,6,6,7,7,8,9,9};
		System.out.println(GetNumberOfK(arr, 6));
	}
}
