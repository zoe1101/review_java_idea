package 其他题目;

public class 累加出整个范围所有的数最少还需要几个数 {
	public static int minNeeds(int[] arr,int range) {
		int needs=0; //需要数的个数
		long touch=0; //表示当前已经解决了1~touch范围上的数
		for (int i = 0; i < arr.length; i++) {
			while (arr[i]>touch+1) { //需要解决[1,arr[i]-1]的数
				touch+=touch+1; //touch+1为需要添加的数，添加后更新touch
				needs++;
				if (touch>=range) {
					return needs;
				}
			}
			touch+=arr[i];
			if (touch>=range) {
				return needs;
			}
		}
		while (range>=touch) {
			touch+=touch+1; //touch+1为需要添加的数，添加后更新touch
			needs++;
		}
		return needs;
	}

}
