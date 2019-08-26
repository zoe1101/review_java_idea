package 数组与矩阵问题;

public class 未排序数组中累加和小于或等于给定值的最长子数组长度 {
	public static int maxLength(int[] arr ,int k) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int sum=0;
		int[] helpArr=new int[arr.length+1]; //记录sum的左侧最大值
		helpArr[0]=sum;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			helpArr[i+1]=Math.max(sum, helpArr[i]);
		}
		sum=0;
		int res=0;
		int pre=0;
		int len=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			pre=getLessIndex(helpArr, sum-k); //找到sum-k的辅助数组的最早出现的位置
			len=pre==-1?0:i-pre+1;
			res=Math.max(res, len);
		}
		return res;
	}
	//利用二分查找实现
	public static int getLessIndex(int[] arr,int num) {
		int low=0;
		int high=arr.length-1;
		int mid=0;
		int res=-1;
		while (low<=high) {
			mid=(high+low)/2;
			if (arr[mid]>=num) { //在左边
				res=mid;
				high=mid-1;
			}else {//在右边
				low=mid+1;
			}
		}
		return res;
	}
	
	
	//方法2
	public static int maxLength2(int[] arr ,int k) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		int[] minSums=new int[arr.length]; //以arr[i]为起始位置的最小和
		int[] minSumEnds=new int[arr.length]; //以arr[i]为起始位置的最小和对应的右边界
		//从右至左计算
		minSums[arr.length-1]=arr[arr.length-1];
		minSumEnds[arr.length-1]=arr.length-1;
		for (int i = arr.length-2; i >=0; i--) {
			if (minSums[i+1]<=0) {
				minSums[i]=arr[i]+minSums[i+1];
				minSumEnds[i]=minSumEnds[i+1];
			}else {
				minSums[i]=arr[i];
				minSumEnds[i]=i;
			}
		}
		int end=0; //end是窗口最右边位置的下一个位置
		int sum=0; //当前窗口中的和,arr[i:end-1]的和
		int res=0;
		
		for (int i = 0; i < arr.length; i++) { //窗口最左边的位置
			while (end<arr.length && sum+minSums[end]<=k) {
				sum+=minSums[end];
				end=minSumEnds[end]+1;
			}
			res=Math.max(res, end-i);
			if (end>i) { //窗口内还有数
				sum-=arr[i];
			}else { //表明窗口内已经没有数了，最小窗口为arr[i:i]
				end=i+1;
			}
		}
		return res;
	}
	
	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3, -2, -4, 0, 6 };
		int k = -2;
		System.out.println(maxLength(arr, k));
		System.out.println(maxLength2(arr, k));

	}

}
