package 数组;

import java.util.HashMap;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//难度：easy
//示例：
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
public class 两数之和 {
	//暴力法
	public int[] violence(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	//两遍哈希表
    public int[] hash2(int[] nums, int target) {
    	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); //定义一个存放整数的哈希表
    	for(int i=0;i<nums.length;i++){
    		record.put(nums[i],i); //将数组值和对应的下标存放于哈希表中。
    	}
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if (record.containsKey(complement) && record.get(complement)!=i) //判断哈希表是否含有元素complement，有则返回true，否则返回false。
            {
                return new int[] {i,record.get(complement)};  //record.get(complement):获取在哈希表中键值为complement对应的值，即原来数组中值对应的下标。
            }
        }
                
        throw new IllegalArgumentException("No two sum solution");
    }
    
  /// 一遍哈希表
  /// Time Complexity: O(n)
  /// Space Complexity: O(n)
    public int[] hash1(int[] nums, int target) {
    	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); //定义一个存放整数的哈希表
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if (record.containsKey(complement)) //判断哈希表是否含有元素complement，有则返回true，否则返回false。
            {
                return new int[] {i,record.get(complement)};  //record.get(complement):获取在哈希表中键值为complement对应的值，即原来数组中值对应的下标。
            }
            
            record.put(nums[i], i);      ////将数组值和对应的下标存放于哈希表中。
        }
        throw new IllegalArgumentException("No two sum solution");
    }


	private static void printArr(int[] nums){
	    for(int num: nums)
	        System.out.print(num + " "); //逐个输出数组元素
	    System.out.println();  //println("test")相当于print("test\n")就是一般的输出字符串, println 将它的参数显示在命令窗口，并在结尾加上换行符，将输出光标定位在下一行的开始。
	}

	public static void main(String[] args) {
	    int[] nums = {0, 4, 3, 0};
	    int target = 3;
	    printArr((new 两数之和()).hash1(nums, target));
	}
}