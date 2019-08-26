package 其他题目;

public class 蓄水池算法 {
	public int[]  getKnumsRand(int k,int max) {
		if (max<1 || k<1) {
			return null;
		}
		int[] res=new int[Math.min(k, max)];
		for (int i = 0; i < res.length; i++) { //将前k个数直接放进袋子中
			res[i]=i+1;
		}
		for (int i = k+1; i <=max; i++) {
			if (rand(i)<=k) { //rand(i)：如果选中i,则i需要进入袋子
				res[rand(k)-1]=i; //从袋子中随机替换一个数字
			}
		}
		return res;
	}
	public static int rand(int max) {
		return (int) (Math.random()*max)+1; //在[1，max]中随机选一个数
	}

}
