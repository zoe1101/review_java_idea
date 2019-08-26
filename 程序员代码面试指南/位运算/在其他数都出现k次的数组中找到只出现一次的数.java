package 位运算;

public class 在其他数都出现k次的数组中找到只出现一次的数 {
	public static int onceNum(int[] arr, int k) {
		int[] eO = new int[32];
		for (int i = 0; i != arr.length; i++) {
			setExclusiveOr(eO, arr[i], k); //eO与curKSysNum无进位相加
		}
		int res = getNumFromKSysNum(eO, k); //k进制转十进制，得到的就是要找的数
		return res;
	}

	public static void setExclusiveOr(int[] eO, int value, int k) {
		int[] curKSysNum = getKSysNumFromNum(value, k); //得到k进制表达
		for (int i = 0; i != eO.length; i++) { //eO与curKSysNum无进位相加
			eO[i] = (eO[i] + curKSysNum[i]) % k;
		}
	}
    //十进制转化为k进制数
	public static int[] getKSysNumFromNum(int value, int k) {
		int[] res = new int[32];
		int index = 0;
		while (value != 0) {
			res[index++] = value % k;
			value = value / k;
		}
		return res;
	}
	//k进制转十进制
	public static int getNumFromKSysNum(int[] eO, int k) {
		int res = 0;
		for (int i = eO.length - 1; i != -1; i--) {
			res = res * k + eO[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test1 = { 1, 1, 1, 2, 6, 6, 2, 2, 10, 10, 10, 12, 12, 12, 6, 9 };
		System.out.println(onceNum(test1, 3));

		int[] test2 = { -1, -1, -1, -1, -1, 2, 2, 2, 4, 2, 2 };
		System.out.println(onceNum(test2, 5));

	}

}
