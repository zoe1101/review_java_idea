package 数组与矩阵问题;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 做项目的最大收益问题 {
	public static class Program{
		public int cost; //项目启动资金
		public int profit; //项目的利润
		public Program(int cost,int profit) {
			this.cost=cost;
			this.profit=profit;
		}
	}
	//定义小根堆如何比较大小
	public static class CostMinComp implements Comparator<Program> {
		@Override
		public int compare(Program o1,Program o2) {
			return o1.cost-o2.cost;
		}
	}
	
	//定义大根堆如何比较大小
	public static class ProfitMaxComp implements Comparator<Program> {
		@Override
		public int compare(Program o1,Program o2) {
			return o2.profit-o1.profit;
		}
	}
	//最大收益
	public static int getMaxProfit(int W,int K,int[] costs,int[] profits) {
		//参数无效
		if (W<1 || K<0 || costs==null || profits==null ||
				costs.length!=profits.length) {
			return W;
		}
		//利用优先队列实现大根堆与小根堆，此时是自定义顺序
		PriorityQueue<Program> costMinHeap=new PriorityQueue<Program>(new CostMinComp()); //花费小根堆
		PriorityQueue<Program> profitMaxHeap=new PriorityQueue<Program>(new ProfitMaxComp()); //利润大根堆
		//所有项目都进花费小根堆
		for (int i = 0; i < costs.length; i++) {
			costMinHeap.add(new Program(costs[i], profits[i]));
		}
		//依次做K个项目
		for (int i = 0; i < K; i++) {
			//考虑那些花费不大于当前资金W的项目，并将这些项目放入利润大根堆中
			while (!costMinHeap.isEmpty() && costMinHeap.peek().cost<=W) {
				profitMaxHeap.add(costMinHeap.poll());
			}
			if (profitMaxHeap.isEmpty()) { //利润大根堆为空，代表没有可以考虑的项目，返回资金W
				return W;
			}
			W+=profitMaxHeap.poll().profit; //如果还可以做项目，则需要从大根堆中拿出堆顶利润最大的项目
		}
		return W;
	}
	
	public static void main(String[] args) {
		int W=3;
		int K=2;
		int[] costs= {5,4,1,2};
		int[] profits= {3,5,3,2};
		System.out.println(getMaxProfit(W, K, costs, profits));

	}
	

}
