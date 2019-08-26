package 校招真题在线编程;

import java.util.Scanner;

/**
小Q正在给一条长度为n的道路设计路灯安置方案。
为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。

输入描述:
输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
第二行一个字符串s表示道路的构造,只包含'.'和'X'。

输出描述:
对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
示例1
输入
2
3
.X.
11
...XX....XX
输出
1
3
 * @author zoe
 *
 */
public class 安置路灯 {
//将道路的构造字符串拆分成字符数组，逐一比对，如果是“.”则跳过照亮的格子，路灯数加一，
//如果不是“.”就比对下一个字符。
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt(); //多少条路
		int[] a=new int[m];
		for (int i = 0; i < m; i++) {
			int n=scanner.nextInt();
			String s=scanner.next();
			a[i] = count(n,s);
		}
		for (int i = 0;i <m; i++) {
            System.out.println(a[i]);    //将所有结果放入数组中，直接遍历输出
        }

	}

private static int count(int n, String s) {
	char[] chas=s.toCharArray();
	int count=0;
	int i=0;
	if (n<=0) {
		return 0;
	}
	while(i<n){
        String j = String.valueOf(chas[i]);
        if(j.equals(".")){    //如果是“.”,那么直接安置一个路灯，跳过照亮的格子，
            i += 3;
            count ++;    //路灯数量加1
        }else{    //如果不是“.”,那么不需要照亮，直接跳过
            i++;
        }
    }
    return count;
}
}
