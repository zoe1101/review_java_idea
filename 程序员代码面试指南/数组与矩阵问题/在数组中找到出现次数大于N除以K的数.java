package 数组与矩阵问题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class 在数组中找到出现次数大于N除以K的数 {
//可以利用哈希表记录每个数的次数实现，但复杂度高
//另一种方法：一次删除K个不同的数，直到剩下的种类不足K时停止，剩余的数就是出现次数大于K/N的数
	
	//打印次数大于一半的数，如果有的话，只会有一个数
	public static void printHalfMajor(int[] arr) {
		int cand=0; //候选数
		int times=0; //候选数出现的次数
		//得到候选数，如果一个数出现次数大一一半，最终会被省下来作为候选
		for (int i = 0; i < arr.length; i++) {
			if (times==0) { //当times=0时，没有候选数,把arr[i]当做候选，同时times置一
				cand=arr[i];
				times=1;
			}else if (arr[i]==cand) { //arr[i]与当前候选数相同，times+1
				times++;
			}else { //arr[i]与当前候选数不同，times-1
				times--;
			}
		}
		//候选数出现次数统计
		times=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==cand) {
				times++;
			}
		}
//		检验候选数是否是真的是次数大于一半的数
		if (times>arr.length/2) {
			System.out.println(cand);
		}else {
			System.out.println("没有出现次数大于一半的数");
		}
	}
	//打印在数组中找到出现次数大于N/K的数
	public static void printKMajor(int[] arr,int K) {
		if (K<=1) {
			System.out.println("K值是无效的");
			return;
		}
		//需要设置K-1个候选，并记录其出现次数
		HashMap<Integer, Integer> cands=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				cands.put(arr[i], cands.get(arr[i])+1);
			}else {
				if (cands.size()==K-1) { //候选数有K个，需要对其进行删除减一操作
					allCandsMinusOne(cands);
				}else { //候选数不足K，需要把arr[i]添做候选
					cands.put(arr[i], 1);
				}
			}
		}
		HashMap<Integer, Integer> reals=getReals(arr, cands);
		boolean hasPrint=false; //标注候选数中是否有满足要求的数
		for(Entry<Integer, Integer> set:cands.entrySet()) {
			Integer key=set.getKey();
			if (reals.get(key)>arr.length/K) {
				hasPrint=true;
				System.out.print(key+" ");
			}
		}
		System.out.println(hasPrint?"":"没有出现次数大于K/N的数");
	}
	 //所有的候选数计数次数减一
	public static void allCandsMinusOne(HashMap<Integer, Integer> cands) {
		List<Integer> removelList=new LinkedList<Integer>(); //记录减一后为0的数
		for(Entry<Integer, Integer> set:cands.entrySet()) {
			Integer key=set.getKey();
			Integer value=set.getValue();
			if (value==1) { //如果当前计数为1，减一后就为0，需要把这个数从候选数中删除
				removelList.add(key);
			}
			cands.put(key, value-1);
		}
		for(Integer removekey:removelList) { //把减一后为0的数从候选数中删除
			cands.remove(removekey);
		}
	}
	//对候选数的真实出现次数进行计数
	public static HashMap<Integer, Integer> getReals(int[] arr,HashMap<Integer, Integer> cands) {
		HashMap<Integer, Integer> reals=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				if (reals.containsKey(arr[i])) {
					reals.put(arr[i], reals.get(arr[i])+1);
				}else {
					reals.put(arr[i], 1);
				}
			}
		}
		return reals;
	}

}
