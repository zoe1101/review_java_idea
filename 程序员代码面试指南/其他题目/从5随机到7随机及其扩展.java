package 其他题目;

public class 从5随机到7随机及其扩展 {
	//随机生成1到5的数
	public static int randTo5() {
		return (int)(Math.random()*5)+1;
	}
	public static int randTo7() {
		int num=0;
		do {
			num=(randTo5()-1)*5+randTo5()-1;
		} while (num>20);
		return num%7+1;
	}
	//01分布，以p的概率生成0,1-拍的概率生成1
	public static int rand01p() {
		double p=0.83;
		return Math.random()<p?0:1;
	}
	public static int rand01() {
		int num;
		do {
			num=rand01p();
		} while (num==rand01p());
		return num;
	}

}
