package 其他题目;
//左右夹击，从两端到中间
public class 判断一个数是否是回文数 {
	public static boolean isPalindrome(int n) {
		if (n==Integer.MIN_VALUE) {
			return false;
		}
		n=Math.abs(n);
		int help=1;
		while (n/help>=10) { //使得help与n位数相同
			help*=10;
		}
		while (n!=0) {
			if (n/help != n%10) { //最高位不等于最低位
				return false;
			}
			n=(n%help)/10;
			help/=100; //一次性会少两位，左边一位，右边一位
		}
		return true;
	}

}
