package 位运算;

public class 不用任何比较判断两个数中较大的数 {
	public static int getMax1(int a,int b) {
		int c=a-b; //存在溢出风险
		int scA=sign(c);
		int scB=flip(scA);
		return a*scA+b*scB;
		
	}
	//整数的正负判定，正数和0返回1，负数返回0
	public static int sign(int n) {
		return  flip((n>>31)&1);
	}
	//就数的正负结果取反，正数返回0，负数返回1
	public static int flip(int n) {
		return n^1;//正数: 1异或1等于0
	}
	
	//解决getMax1中的溢出风险
	public static int getMax2(int a,int b) {
		int c=a-b;
		int sa=sign(a);
		int sb=sign(b);
		int sc=sign(c);
		int difSab=sa^sb; //a与b的符号不同，为1
		int sameSab=flip(difSab); //difSab为1，则为0
		//difSab与sameSab是反的
		int returnA=difSab*sa+sameSab*sc;
		int returnB=flip(returnA);
		return a*returnA+b*returnB;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
