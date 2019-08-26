package 数组与矩阵问题;

public class 不包含本位置值的累乘数组 {
	//常规方法，使用除法实现
	public static int[] product1(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int count=0; //对0进行计数
		int allproduct=1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=0) {
				allproduct*=arr[i];
			}else {
				count++;
			}
		}
		int[] res=new int[arr.length];
		if (count==0) { //没有0元素
			for (int i = 0; i < arr.length; i++) {
				res[i]=allproduct/arr[i];
			}
		}
		if (count==1) { //只有1个0,则除0所在的位置外，累乘结果都为0
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]==0) {
					res[i]=allproduct;
				}
			}
		}
		//如果0的个数多于一个，那么所有结果都为0
		return res;
	}
	
	//不能使用除法时，使用左边元素乘积乘以右边元素乘积
	public static int[] product2(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int[] left=new int[arr.length];//左边元素乘积
		int[] right=new int[arr.length]; //右边元素乘积
		left[0]=1;
		right[arr.length-1]=1;
		for (int i = 1; i < arr.length; i++) {
			left[i]=left[i-1]*arr[i-1];
		}
		for (int i = arr.length-2; i>=0; i--) {
			right[i]=right[i+1]*arr[i+1];
		}
		int[] res=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i]=left[i]*right[i];
		}
		return res;
	}
	//对方法2进行优化，复用结果数组
	public static int[] product3(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int[] res=new int[arr.length];
		res[0]=arr[0];
		for (int i = 1; i < arr.length; i++) { //记录左边乘积结果
			res[i]=res[i-1]*arr[i];
		}
		int tmp=1;
		for (int i = arr.length-1; i>0 ; i--) {
			res[i]=res[i-1]*tmp;  //左边乘以右边
			tmp*=arr[i]; //右边乘积结果
		}
		res[0]=tmp; //第一个位置，等于右边乘积结果
		return res;
		
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] res1 = product1(arr);
		printArray(res1);
		int[] res2 = product2(arr);
		printArray(res2);
		int[] res3 = product3(arr);
		printArray(res3);

	}

}
