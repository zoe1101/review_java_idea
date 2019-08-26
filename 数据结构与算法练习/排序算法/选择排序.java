package 排序算法;
import java.util.Arrays;


//选择排序：（比冒泡排序更快，运行次数更少）
public class 选择排序 {
	
//    从小到大
	public static int[] SmalltoBig(int[] arr) {
		if (arr==null || arr.length<2) {
			return arr;
		}
		//每次选最小的方前面
		for(int i=0;i<arr.length-1;i++) {  //i为已排序序列的末尾
			for (int j=i+1;j<arr.length;j++) { //j为未排序序列
				if(arr[j]<arr[i]) {  //找出未排序序列中的最小值
					swap(arr,i,j);
					//元素交换位置，放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
				}
			}
		}
		return arr;
	}


//    从大到小
	public static int[] BigtoSmall(int[] arr) {
		if (arr==null || arr.length<2) {
			return arr;
		}
		//每次选最大的放前面
		for(int i=0;i<arr.length-1;i++) { //前i+1个元素已经排好序了，无序再动
			for (int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[i]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

	//生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//(int)((maxSize + 1) * Math.random())： [0,maxSize]中随机生成一个值作为数组长度
		int[] arr=new int[(int)((maxSize + 1) * Math.random())]; 
		for (int i = 0; i < arr.length; i++) {
			//随机生成属于[-maxValue,maxValue]的值
			arr[i]=(int) ((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	

	// 打印数组元素
	public static void printArray(int[] arr) {
		if (arr==null) {
			return ;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int maxSize = 20; //数组最大长度
		int maxValue = 50; //元素最大值
		int[] arr1= generateRandomArray(maxSize, maxValue);
		printArray(arr1);
		printArray(BigtoSmall(arr1));
		printArray(SmalltoBig(arr1));
	}

}
