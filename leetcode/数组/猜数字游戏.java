package 数组;
/*
你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。

请注意秘密数字和朋友的猜测数都可能含有重复数字。

输入: secret = "1807", guess = "7810"
输出: "1A3B"
解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 */
//难度: medium
//统计同一位置字母相同的个数即为bull的个数，
//把secret和guess其他情况下的字符剩余数目分别统计，到时取两着最小值累加起来即可，也就是cow值。
public class 猜数字游戏 {
    public String getHint(String secret, String guess) {
        int a=0;
        int b=0;
        int[]  cache1=new int[10];  //[0,9]中的数字出现个数统计
        int[]  cache2=new int[10];
        for(int i=0;i<secret.length();i++) {
        	if(secret.charAt(i)==guess.charAt(i)) {
        		a++;
        	}else {// 将secret中含有的数字放入
        		 cache1[secret.charAt(i)-'0']++; // 将secret中含有的数字放入,进行统计
        		 cache2[guess.charAt(i)-'0']++;  // 将guess中含有的数字放入,进行统计
			}
        }
        for (int i = 0; i < cache1.length; i++) {  // 计算b的大小
			b+=Math.min(cache1[i], cache2[i]);
        }
		return a+"A"+b+"B";
    }
}
