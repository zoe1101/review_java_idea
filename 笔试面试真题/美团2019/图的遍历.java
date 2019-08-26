package 美团2019;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
给定N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。
假设你从1节点出发并打算遍历所有节点，那么总路程至少是多少？ 
输入： 
第一行包含一个整数N，1≤N≤105105 
接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X,Y≤N 
输出： 
输出总路程的最小值 
样例输入： 
4 
1 2 
1 3 
3 4 
样例输出： 
4 
提示： 
按1->2->1->3->4的路线遍历所有节点，总路程为4

 */
//深度优先遍历
//看到N个节点，N-1边，而且还是连通图，所以可以确定这个图，实际上是一颗生成树。
//同时，因为是树，所以肯定没有环。 
//有n个顶点进行深度遍历时，除去最长的那条路径所含的边只走一次之外，其他每条边经过两次。
//所以只需要找出深度最深的路径就可，设最深的路径长度为L，总路程为2*（n-1）-L。
public class 图的遍历 {
	private static int maxpath=0;
	private static int temp=0;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		List<Integer>[] list=new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i]=new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			 int key = scanner.nextInt();
             int value = scanner.nextInt();
             list[key].add(value);
		}
		dfs(1,list); //得到最长路径
		System.out.println(2*(n-1)-maxpath);
		scanner.close();
	}

	public static void dfs(int n,List <Integer> [] list) {
    	if(list[n].size()==0) {
    		if(temp>maxpath)
    			maxpath=temp;
    		return;
    	}else {
    		for (int i = 0; i < list[n].size(); i++) {
				temp++;
				dfs(list[n].get(i),list);
				temp--;
			}
    	}
    }

}
