package 位运算;

public class 整数的二进制表达中有多少个1 {
	public static int countOne1(int n) {
		int res=0;
		while (n!=0) {
			res+=n&1; //检查最低位是否为1
			n>>>=1; //n=n>>>1,n逻辑右移1位
		}
		return res;
	}
	
	public static int countOne2(int n) {
		int res=0;
		while (n!=0) {
			n&=(n-1); //每次都可以忽略掉bit位上为0的部分
			res++;
		}
		return res;
	}
	public static int countOne3(int n) {
		int res=0;
		while (n!=0) {
			n-=n&(~n+1); //每次可以忽略掉bit位最右边的为1
			res++;
		}
		return res;
	}
	//平行算法
	public static int countOne4(int n) {
		n=(n&0x55555555)+((n>>>1)&0x55555555);
		n=(n&0x33333333)+((n>>>2)&0x33333333);
		n=(n&0x0f0f0f0f)+((n>>>4)&0x0f0f0f0f);
		n=(n&0x00ff00ff)+((n>>>8)&0x00ff00ff);
		n=(n&0x0000ffff)+((n>>>16)&0x0000ffff);
		return n;

	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
