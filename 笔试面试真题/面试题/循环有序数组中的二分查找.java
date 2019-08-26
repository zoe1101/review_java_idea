package 面试题;
/*
一个循环有序数组（如：3,4,5,6,7,8,9,0,1,2），不知道其最小值的位置，要查找任一数值的位置。
找到的话返回下标，没找到返回-1。

要求算法时间复杂度为log2(n)。
 */
//解题思路: 二分查找

public class 循环有序数组中的二分查找 {
	
//	非递归法
    public static int bisearch1(int[] arr,int target){
    	int left=0;
    	int right=arr.length-1;
    	while (left<=right) {
    		int mid=left+(right-left)/2;  //为了防止数值溢出
    		if(target==arr[mid]) {
    			return mid;
    		}
            // A[left], A[mid], A[right]  
            // 6 1 5 
    		if (arr[mid]<=arr[left]) {//转折点在mid的左侧，即mid到right都是有序递增的
    			if(target>arr[mid] && target<=arr[right]) {//在mid的右边
    				left=mid+1;
    			}else {//在mid的左边
    				right=mid-1;
    			}
			// 3 6 2
    		}else {//转折点在mid的右侧，即left到mid都是有序递增的
        			if(target>=arr[left] && target<arr[mid]) {//在mid的左边
        				right=mid-1;
        			}else {//在mid的右边
        				left=mid+1;
        			}
    		}

		}
    	return -1;	
    }
    
//	递归写法
    public static int bisearch2(int[] arr,int left, int right,int target){
    	while (left<=right) {
    		int mid=left+(right-left)/2;  //为了防止数值溢出
    		if(target==arr[mid]) {
    			return mid;
    		}
            // A[left], A[mid], A[right]  
            // 6 1 5 
    		if (arr[mid]<=arr[left]) {//转折点在mid的左侧，即mid到right都是有序递增的
    			if(target>arr[mid] && target<=arr[right]) {//在mid的右边
    				return bisearch2(arr, mid+1, right, target);
    			}else {//在mid的左边
    				return bisearch2(arr, left, mid-1, target);
    			}
			// 3 6 2
    		}else {//转折点在mid的右侧，即left到mid都是有序递增的
        			if(target>=arr[left] && target<arr[mid]) {//在mid的左边
        				return bisearch2(arr, left, mid-1, target);
        			}else {//在mid的右边
        				return bisearch2(arr, mid+1, right, target);
        			}
    		}

		}
    	return -1;	
    }
    
//    true or false
    public static boolean bisearch3(int[] A, int left, int right, int target)  
    {  
        if(left > right)  
            return false;  
        int mid=left+(right-left)/2;  //为了防止数值溢出
        if(target == A[mid])  
            return true;  
        // A[left], A[mid], A[right]  
        // 1 3 5  
        if(A[mid] > A[left] && A[mid] < A[right]) //普通二分  
        {  
            if(target < A[mid])  
                return bisearch3(A, left, mid-1, target);  
            else  
                return bisearch3(A, mid+1, right, target);  
        }  
        // 5 1 3  
        else if(A[mid] < A[left] && A[mid] < A[right]) //转折在左侧  
        {  
            if(target > A[mid] && target <= A[right])  
                return bisearch3(A, mid+1, right, target);  
            else  
                return bisearch3(A, left, mid-1, target);  
        }  
        // 3 5 1  
        else if(A[mid] > A[left] && A[mid] > A[right]) //转折在右侧  
        {  
            if(target < A[mid] && target >= A[left])  
                return bisearch3(A, left, mid-1, target);  
            else  
                return bisearch3(A, mid+1, right, target);  
        }  
        // 3 3 3  
        else //只有这种左中右都相等的情况下没有办法判断  
        {  
            return bisearch3(A, left, mid-1, target) || bisearch3(A, mid+1, right, target);
        }  
    }  


	public static void main(String[] args) {
        int[] arr = new int[]{23,24,26,27,27,4,4,4,8,13,20};
        System.out.println(bisearch1(arr, 4));
        System.out.println(bisearch2(arr, 0,arr.length,4));
	}
}
