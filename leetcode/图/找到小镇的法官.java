package 图;
/*
在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
如果小镇的法官真的存在，那么：
小镇的法官不相信任何人。
每个人（除了小镇法官外）都信任小镇的法官。
只有一个人同时满足属性 1 和属性 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

输入：N = 3, trust = [[1,3],[2,3]]
输出：3
 */

public class 找到小镇的法官 {
    public static int findJudge(int N, int[][] trust) {
        int[][] degree=new int[N][2]; //记录每个人的入度和出度
        for(int[] person:trust) {
        	int out=person[0]; //出度
        	int in=person[1];  //入度
        	degree[out-1][0]++;
        	degree[in-1][1]++;
        }
        for(int i=0;i<N;i++) {
        	if(degree[i][0]==0 && degree[i][1]==N-1) { //出度为0，入度为N-1的就是法官
        		return i+1;
        	}
        }
        return -1;
    }

	public static void main(String[] args) {

	}

}
