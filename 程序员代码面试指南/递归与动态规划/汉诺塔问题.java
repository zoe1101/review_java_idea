package 递归与动态规划;

public class 汉诺塔问题 {
	public static void hanoi(int n) {
		if (n>0) {
			func(n, "left", "mid", "right");
		}
	}
	//最优移动轨迹
	public static void func(int n,String from,String mid,String to) {
		if (n==1) {
			System.out.println("move from "+from+" to "+to);
		}else {
			func(n-1, from, to, mid); //先将上面的n-1个盘子从左边移动到中间
			func(1, from, mid, to);   //再将第n个盘子从左边移动到右边
			func(n-1, mid, from, to); //最后将咋中间的n-1个盘子移动到右边
		}
	}
	/*
	 arr[i]的值代表第i+1个圆盘所在的位置
	返回arr数组所表示的状态是最优移动轨迹中的第几个状态，如果不属于最优移动轨迹就返回-1
	*/
	
	//方法1
	public static int step1(int[] arr) {
		if (arr==null || arr.length==0) {
			return -1;
		}
		return process(arr, arr.length-1, 1, 2, 3);
	}

	//方法2
	public static int step2(int[] arr) {
		if (arr==null || arr.length==0) {
			return -1;
		}
		int from=1; //左边
		int mid=2; //中间
		int to=3;  //右边
		int i=arr.length-1;
		int res=0;
		int temp=0;//用于存储中间值
		while (i>0) {
			if (arr[i]!=from && arr[i]!=to) {//圆盘i不在左边和右边时，即圆盘在中间是不可能的
				return -1;
			}
			if (arr[i]==to) {//圆盘i在右边，表明在处理将前i-1个盘子从中间移动到右边过程中
				res+=1<<i;
				temp=from;
				from=mid;
			}else {//圆盘i在左边，表明还在处理前i-1个盘子
				temp=to;
				to=mid;
			}
			mid=temp;
			i--;
		}
		return res;
	}
	
	public static int process(int[] arr,int i,int from,int mid,int to) {
		if (i==-1) {
			return 0;
		}
		if (arr[i]!=from && arr[i]!=to) { //圆盘i不在左边和右边时，即圆盘在中间是不可能的
			return -1;
		}
		if (arr[i]==from) {//圆盘i在左边，表明还在处理前i-1个盘子
			return process(arr, i-1, from, to, mid);
		}else {//圆盘i在右边，表明在处理将前i-1个盘子从中间移动到右边过程中
			int rest=process(arr, i-1, mid, from, to);
			if (rest==-1) {
				return -1;
			}
			return (1<<i)+rest;
		}
	}
	public static void main(String[] args) {
		int n = 4;
		hanoi(n);

		int[] arr = { 3, 3, 2, 1 };
		System.out.println(step1(arr));
		System.out.println(step2(arr));

	}
}
