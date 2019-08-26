package 数组与矩阵问题;

import java.util.Arrays;

public class 加油站良好出发点问题 {
	//返回每个点是否可以作为出发点的数组
	public static boolean[] stations(int[] dis,int[] oil) {
		 //无效参数
		if (dis==null || oil==null || dis.length<2 || dis.length!=oil.length) {
			return null;
		}
		int init=changeDisArrayGetInit(dis, oil); //得到纯能数组dis，同时得到有效出发点init
		return init==-1?new boolean[dis.length]:enlargeArea(dis,init);
	}
	
	//修改dis数组，同时得到有效出发点init
	public static int changeDisArrayGetInit(int[] dis,int[] oil) {
		int init=-1;
		for (int i = 0; i < dis.length; i++) {
			dis[i]=oil[i]-dis[i]; //将dis数组改为oil数组减原dis数组
			//oil[i]-dis[i]：表示从i位置走到下一个位置，但还没有加上下一个位置的油量之前的剩余油量
			if (dis[i]>=0) {//只有修改后的dis[i]大于等于0的点才可以作为出发点
				init=i;
			}
		}
		return init;
	}
	//最大化从init出发的连通区域
	//连通区表示为[start,end)
	public static boolean[] enlargeArea(int[] dis,int init){
		boolean[] res=new boolean[dis.length];
		int start=init;
		int end=nextIndex(init, dis.length);
		int need=0; //从start位置顺时针扩充连通区的要求
		int rest=0; //从end位置逆时针扩充连通区的资源
		do {
			//当前来到的start已经在连通区域中，可以确定后续的开始点一定无法转完一圈
			if (start!=init && start==lastIndex(end, dis.length)) {
				break;
			}
			//当前来到的start不在连通区域中，就扩充连通区域
			if (dis[start]<need) { //从当前start出发，无法到达initinal点
				need-=dis[start];
			}else { //从当前start出发，可以到达initinal点，扩充连通区域的结束点
				rest+=dis[start]-need;
				need=0;
				while (rest>=0 && end!=start) {
					rest+=dis[end];
					end=nextIndex(end, dis.length);
				}
				if (rest>=0) {
					res[start]=true;
					connectGood(dis,lastIndex(start, dis.length),init,res);
					break;
				}
			}
			start=lastIndex(start, dis.length);
		} while (start!=init);
		return res;
	}
	public static void connectGood(int[] dis,int start,int init,boolean[] res){
		int need=0;
		while (start!=init) {
			if (dis[start]<need) {
				need-=dis[start];
			}else {
				res[start]=true;
				need=0;
			}
			start=lastIndex(start, dis.length);
		}
	}
	//前一个位置，顺时针
	public static int lastIndex(int index,int size) {
		return index==0?size-1:index-1;
	}
	//下一个位置，逆时针
	public static int nextIndex(int index,int size) {
		return index==size-1?0:(index+1);
	}
	
	public static void main(String[] args) {
		int[] dis= {1,9,1,2,6,0,2,0};
		int[] oil= {4,5,3,1,5,1,1,9};
		System.out.println(Arrays.toString(stations(dis, oil)));

	}

}
