package 数组与矩阵问题;

public class 数组的partition调整 {
	public static void leftUnique(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int u=0; //左边界
		int i=1;//左边界的右边
		while (i<arr.length) { 
			if (arr[i]!=arr[u]) { //右半部分的arr[i]没有出现在左半部分，则应该把arr[i]加入左半部分
				swap(arr, ++u, i); //把arr[i]与arr[u+1]交换位置，即在左半部分加上arr[i]
			}
			i++;
		}
	}
	//对只有0,1,2的数组进行排序
	public static void sort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int maxLeft=-1;
		int index=0;
		int minRight=arr.length;
		while (index<minRight) {
			if (arr[index]==0) {//arr[index]属于左边区域
				swap(arr, ++maxLeft, index++);
			}else if (arr[index]==2) { //arr[index]属于右边区域
				swap(arr, index, --minRight);
			}else { //arr[index]属于中间区域
				index++;
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		printArray(arr1);
		leftUnique(arr1);
		printArray(arr1);

		System.out.println();

		int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
		printArray(arr2);
		sort(arr2);
		printArray(arr2);

	}

}
