package 数组;
/*
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 
如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。

输入: 
gas  = [1,2,3,4,5]  //油量
cost = [3,4,5,1,2]  //从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 
输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:
 */
//难度:medium

public class 加油站 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas.length!=cost.length||gas.length==0) {
    		return -1;
    	}
    	
    	int total=0;//可以剩余的油量
		int sum=0; //当前剩余油量
    	int start=0; //开始设置起点
    	
        for(int i=0;i<gas.length;i++) {
        	total+=gas[i]-cost[i]; 
        	sum+=gas[i]-cost[i]; 
        	if(sum<0) { //当到达某一站点时，若这个值小于0了，则说明从起点到这个点中间的任何一个点都不能作为起点，
//        		则把起点设为下一个点，继续遍历。
        		start=i+1; 
        		sum=0;
        	}
        }
        return (total>=0)?start:-1; //total>=0,确保油量不少于消耗量
    }
    
	public static void main(String[] args) {
		int[] gas  = {1,2,3,4,5}; //油量
		int[] cost = {3,4,5,1,2}; //从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 
		System.out.print(canCompleteCircuit(gas,cost));
	}
}
