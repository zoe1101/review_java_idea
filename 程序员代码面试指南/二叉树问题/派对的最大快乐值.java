package 二叉树问题;

import java.util.List;

public class 派对的最大快乐值 {
	public static class Employee { 
		public int happy; // 这名员工可以带来的快乐值
	    public List<Employee> nexts; // 这名员工有哪些直接下级 
	}
	
	// 得到一个员工，来or不来，分别对应的最大happy！！！！
	public static class ReturnType{
		public int laiMaxHappy;
		public int buMaxHappy;
		public ReturnType(int lai, int bu) {
			laiMaxHappy = lai;
			buMaxHappy = bu;
		}
	}
	
	public static int maxHappy(Employee boss) {
		ReturnType headInfo = process(boss);
		return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
	}
	

	// 得到一个员工，来or不来，分别对应的最大happy！！！！
	public static ReturnType process(Employee x) {
		//1. base case
		if(x.nexts.isEmpty()) {
			return new ReturnType(x.happy,0);
		}
		int lai = x.happy;
		int bu = 0;
		for(Employee next : x.nexts) {
			ReturnType nextInfo = process(next);// 2. 默得到子树的info信息
			// 3. 整合信息【拆解黑盒，得到info中具体的】
			lai += nextInfo.buMaxHappy;
			bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
		}// 4. 返回ReturnType
		return new ReturnType(lai,bu);
	}
}
