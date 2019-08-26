package Math;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class 回文数 {
	public static boolean isPalindrome(int x) { 
		if(x<0||( x%10==0&& x!=0)) {//如果是负数或者这个数个位为0，则返回false（0除外）
			return false;
		}
		int rev=0;//记录逆转的一半
		while (x>rev) {
			rev=rev*10+x%10;
			x=x/10;
		}
	     return (rev==x||x==rev/10);  //rev==x:偶位数，x==rev/10：奇位数
    }
	public static void main(String[] args) {
		int x=12321;
		System.out.println(isPalindrome(x));

	}

}
