package 排序算法;

import java.util.ArrayList;
import java.util.Collections;

public class 桶排序 {
	public static void buckeSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
		int max = Integer.MIN_VALUE; //数组中的最大值
	    int min = Integer.MAX_VALUE;  //数组中的最小值
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    int bucketNum = (max - min) / arr.length + 1; //桶数
	    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum); //桶数组
	    for(int i = 0; i < bucketNum; i++){
	        bucketArr.add(new ArrayList<Integer>());
	    }
	    
	    //将每个元素放入桶
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / (arr.length); //该元素属于哪一个桶
	        bucketArr.get(num).add(arr[i]); //压入对应桶
	    }
	    
	    //对每个桶进行排序
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));
	    }
	    
	    System.out.println(bucketArr.toString());
	}
	public static void main(String[] args)
    {
		int[] arr= {1,2,3,6,2,7,4,6};
		buckeSort(arr);
    }
	

}
