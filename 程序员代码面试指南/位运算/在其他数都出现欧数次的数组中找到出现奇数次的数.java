package 位运算;

public class 在其他数都出现欧数次的数组中找到出现奇数次的数 {
	
	//只有一个数出现奇数次
	public static void printOddTimeNum1(int[] arr) {
		int eo=0;
		for (int cur:arr) {
			eo^=cur;
		}
		System.out.println(eo);
	}
	//只有两个数出现奇数次
	public static void printOddTimeNum2(int[] arr) {
		int eo=0;
		int eohasOne=0; //两个数中的其中一个
		for (int cur:arr) {
			eo^=cur;
		}
		int rightOne=eo&(~eo+1);
		for(int cur:arr) {
			if((cur &rightOne)!=0) {
				eohasOne^=cur;
			}
		}
		System.out.println(eohasOne+" "+(eo^eohasOne));//(eo^eohasOne):另一个
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimeNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimeNum2(arr2);

	}

}
