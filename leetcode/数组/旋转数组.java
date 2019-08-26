package 数组;
/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
 */
//难度: easy
public class 旋转数组 {
	//右移k次
    /* 双重循环
           * 时间复杂度：O(kn)
           * 空间复杂度：O(1)
    */
    public static void rotate1(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	
		if(k==0)
			return;
        for(int i=0;i<k;i++) {
    		int temp=nums[n-1];
    		for(int j=n-1;j>0;j--) {
        		nums[j]=nums[j-1];
        	}
    		nums[0]=temp;
        }
    }

	//借用临时空间
    public static void rotate2(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	int[] temp=new int[k]; //临时空间
    	
		if(k==0)
			return;
        for(int i=0;i<k;i++) {
    		temp[i]=nums[n-k+i];
        }
        for(int i=n-1;i>=k;i--) {
        		nums[i]=nums[i-k];
        	}
        for(int i=0;i<k;i++) {
        	nums[i]=temp[i];
        }
    }
  /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void rotate3(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	
		if(k==0) return;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
       
    }
    
    private static int[] reverse(int[] nums,int start,int end) {
    	while (start<end) {
			int temp=nums[start];
			nums[start++]=nums[end];
			nums[end--]=temp;
		}
    	return nums;
		
	}

	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		int k=3;
		rotate2(nums, k);
		

	}

}
