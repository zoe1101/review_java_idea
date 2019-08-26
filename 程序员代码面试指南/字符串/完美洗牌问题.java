package 字符串;

import java.util.Arrays;

import javax.swing.table.TableRowSorter;

/**
 * 有个长度为2n的数组{a1,a2,a3,…,an,b1,b2,b3,…,bn}，希望排序后{a1,b1,a2,b2,….,an,bn}
 * 时间复杂度o(n)，空间复杂度0(1)
 * @author zoe
 *
 */
public class 完美洗牌问题 {
	/**
	 * 位置调整,位置索引从1开始
	 * @param i
	 * @param len
	 */
	public static int modify1(int i,int len) {
		if(i<=len/2) {
			return 2*i;
		}else {
			return 2*(i-len/2)-1;
		}
	}
	//modify1的修正版
	public static int modify2(int i,int len) {
		return (2*i)%(len+1);
	}

	
	/**
	 * 主函数
	 * @param arr
	 */
	public static void shuffle(int[] arr) {
		if(arr!=null && arr.length!=0&& (arr.length&1)==0) {//数组必须不为空且长度为偶数
			shuffle(arr,0,arr.length-1);
		}
	}
	
	public static void shuffle(int[] arr,int left,int right) {
		while (right-left+1>0) { //切成一块一块解决,每块长度满足（3^k）-1
			int len=right-left+1;
			int base=3;
			int k=1;
			while (base<=(len+1)/3) { //找出在len范围内的，满足（3^k）-1且离len最近的数，即找到最大的k
				base*=3;
				k++;
			}
			int half=(base-1)/2; //当前需要解决长度为base-1的块，一半就是再除以2
			int mid=(left+right)/2; //[left,Right]的中间位置
			rotate(arr, left+half, mid, mid+half);//以mid为界，将左边[left+half,mid]的元素移到右边的后面
			cycles(arr, left, base-1, k); //从left开始，进行长度为base-1的部分连续下标推
			left=left+base-1; //继续处理剩余部分
			
		}
	}
	/**
	 * 连续下标推，从start开始，在向右len长度这一段里进行
	 * @param arr
	 * @param start
	 * @param len
	 * @param k
	 */
	public static void cycles(int[] arr,int start,int len,int k) {
	//      trigger:每一个环的出发位置，一共有k个
	//		每一个trigger都需进行连续下标推
	//		出发位置trigger从1开始，但数组下标从0开始
		for(int i=0,trigger=1;i<k;i++,trigger*=3) {
			int preValue=arr[trigger+start-1];
			int cur=modify2(trigger, len);
			while (cur!=trigger) {
				int tmp=arr[cur+start-1];
				arr[cur+start-1]=preValue;
				preValue=tmp;
				cur=modify2(cur, len);
			}
			arr[cur+start-1]=preValue;
		}
	}
	/**
	 * 左半部分与右半部分交换
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void rotate(int[] arr,int left,int mid,int right) {
		reverse(arr, left, mid);
		reverse(arr, mid+1, right);
		reverse(arr, left, right);
	}
	/**
	 * 数组部分逆序
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void reverse(int[] arr, int left,int right) {
		while (left<right) {
			int tmp=arr[left];
			arr[left]=arr[right];
			arr[right]=tmp;
			left++;
			right--;
		}
	}
	/**
	 * 将数字数组，调整为满足依次相邻的数字总是先<=，、再>=的关系,例如a<=b>=c<=d>=e.
	 * @param arr
	 */
	
	public static void wiggleSort(int[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		Arrays.sort(arr);
		if((arr.length&1)==1) { //奇数
			shuffle(arr, 1, arr.length-1);
		}else { //偶数
			shuffle(arr, 0, arr.length-1);
			for(int i=0;i<arr.length;i+=2) {
				int tmp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=tmp;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(arr));
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}


}
