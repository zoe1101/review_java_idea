package 数组;

public class 数组的拷贝 {
	public static void main(String[] args) {
		String[] s= {"A","B","C","D"};
		String[] s2=new String[10];
		System.arraycopy(s,0,s2,0,s.length);  //将s数组里的元素值赋给s2数组的元素
		for (int i = 0; i < s2.length; i++) {
			System.out.print(s2[i]+" ");
		}
	}

}
