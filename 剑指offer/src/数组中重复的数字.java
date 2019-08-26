package src;

import java.util.HashMap;

/*
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class 数组中重复的数字 {
	
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	//在Java的方法中，可以用duplication[0]代替C/C++中的指针*duplication，
	//从而在返回boolean的同时，也可以获得需要的数字。
	
	
	
	//采用hashmap存放每个元素
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(numbers==null || numbers.length==0) {
	    	return false;
	    }
	    HashMap<Integer , Integer> map=new HashMap<Integer, Integer>();
	    for(int i=0;i<numbers.length;i++) {
	    	if(map.containsKey(numbers[i])) {
	    		duplication[0]=numbers[i];
	    		return true;
	    	}
	    	map.put(numbers[i], 0);
	    }
	    return false;
    }
	
//重排数组:
//把扫描的每个数字（如数字m）放到其对应下标（m下标）的位置上，若同一位置有重复，则说明该数字重复。
	public boolean duplicate2(int numbers[],int length,int [] duplication) {
		if(numbers==null||length<=0)
            return false;
        for(int a:numbers){
            if(a<0||a>=length)
                return false;
        }
        int temp;
        for(int i=0;i<length;i++){
        	 while(numbers[i]!=i){
                 if(numbers[numbers[i]]==numbers[i]){
                     duplication[0]=numbers[i];
                     return true;
                 }
                 //// 交换numbers[numbers[i]]和numbers[i]
                 temp=numbers[i];
                 numbers[i]=numbers[temp];
                 numbers[temp]=temp;
             }
         }
         return false;
	}
}
