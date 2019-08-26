package 其他题目;

public class 关于阶乘的问题 {
	//想要有0，就得是2*5，那么需要找出1到num的数的因子2,5的个数，2会比5多
	//所以只要找到能被5整除的数的个数就可以了
	public static int zeroNum1(int num) {
		if (num<0) { //只处理非负数
			return 0;
		}
		int res=0;
		int cur=0;
		for (int i = 5; i <= num; i=i+5) {
			cur=i;
			while (cur%5==0) {
				res++;
				cur/=5;
			}
		}
		return res;
	}
	//改进
	public static int zeroNum2(int num) {
		if (num<0) { //只处理非负数
			return 0;
		}
		int res=0;
		while (num!=0) {
			res+=num/5;
			num/=5;
		}
		return res;
		
	}

}
