package 其他题目;

public class 从N个数中等概率打印M个数 {
	//将打印过的数放在数组的右半部分
	public static void printRandM(int[] arr,int m) {
		if (arr==null ||arr.length==0|| m<1) {
			return ;
		}
		m=Math.min(m, arr.length);
		int count=0;
		int index=0;
		while (count<m) {
			index=(int)(Math.random()*(arr.length-count)); //从1到n-count中随机选一个数
			System.out.println(arr[index]);
			swap(arr, index, arr.length-count-1); //将当前选中的数与左边未打印部分的最后一个数交换
			count++;
		}
	}
	public static void swap(int[] arr ,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {2,45,67,3,25,2,5,3,5,7};
		printRandM(arr, 4);
	}

}
