package 其他题目;
/*
 *一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下： 
　　1、每个孩子不管得分多少，起码分到1个糖果 
　　2、任意两个相邻的孩子之间，得分较多的孩子必须多拿一些糖果
	    3、任意两个相邻的孩子之间如果得分相同，糖果数必须相同

给定一个数组arr代表得分数组，返回最少需要多少糖果。 
例如：arr = [1,2,2]，糖果分配[1,2,2]，即可满足要求且数量最少，所以返回5.
 */
public class 分糖果问题2 {
	public static int candy(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int index=nextMinIndex(arr,0); 
		int[] data=rightCandsAndBase(arr, 0, index++);
		int res=data[0];
		
		int lbase=1; //左坡的起始值
		int same=1;
		int next=0;
		while (index!=arr.length) {
			if (arr[index]>arr[index-1]) {
				res+=++lbase;
				same=1;
				index++;
			}else if (arr[index]<arr[index-1]) {
				next=nextMinIndex(arr, index-1);
				data=rightCandsAndBase(arr, index-1, next++);
				if (data[1]<=lbase) {
					res+=data[0]-data[1];
				}else {
					res+=-lbase*same+data[0]-data[1]+data[1]*same;
				}
				lbase=1;
				index=next;
				same=1;
			}else {
				res+=lbase;
				same=1;
				index++;
			}
		}
		return res;
	}

	private static int nextMinIndex(int[] arr, int start) {
		for (int i = start; i < arr.length-1; i++) {
			if (arr[i]<arr[i+1]) { 
				return i;
			}
		}
		return arr.length-1;
	}
	
	private static int[] rightCandsAndBase(int[] arr, int left, int right) {
		int base=1;
		int cands=1;
		for (int i = right-1; i >=left; i--) {
			if (arr[i]==arr[i+1]) {
				cands+=base;
			}else {
				cands+=++base;
			}
		}
		return new int[] {cands,base};
	}
}
