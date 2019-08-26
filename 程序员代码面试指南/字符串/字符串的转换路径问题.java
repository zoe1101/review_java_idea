package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class 字符串的转换路径问题 {
	public static List<List<String>> findMinPaths(String start, String to,List<String> list) {
		list.add(start);
		HashMap<String, ArrayList<String>> nexts=getNexts(list);
		HashMap<String, Integer> distances=getDistances(start, nexts);
		LinkedList<String> pathList=new LinkedList<String>();
		List<List<String>> res=new ArrayList<List<String>>();
		getShortestPaths(start, to, nexts, distances, pathList, res);
		return res;
	}
	//得到每一个字符串变换一个字符后的字符串nexts
	public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
		Set<String> dict=new HashSet<String>(words);
		HashMap<String,  ArrayList<String>> nexts=new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < words.size(); i++) { //把每一个字符串放在首位，作为start字符串
			nexts.put(words.get(i), new ArrayList<String>());
		}
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i),getNext(words.get(i),dict));
		}
		return nexts;
	}
	public static ArrayList<String> getNext(String word,Set<String> dict) {
		ArrayList<String> res=new ArrayList<String>();
		char[] chas=word.toCharArray();
		for(char cur='a';cur<='z';cur++) {
			for (int i = 0; i < chas.length; i++) {
				char tmp = chas[i];
				chas[i]=cur; //把字符换成遍历的某一字符
				if (dict.contains(String.valueOf(chas))) { //将字典列表中有的放在next里
					res.add(String.valueOf(chas));
				}
				chas[i]=tmp; //把更改后的字符换成原来的字符
			}
		}
		return res;
	}
	
	//求出每一个字符串到start字符串的最短近距离
	public static HashMap<String, Integer> getDistances(String start,HashMap<String, ArrayList<String>> nexts) {
		HashMap<String, Integer> distances=new HashMap<String, Integer>();
		distances.put(start, 0);
		Queue<String> queue=new LinkedList<String>();
		queue.add(start);
		HashSet<String> set=new HashSet<String>();
		set.add(start);
		while (!queue.isEmpty()) { //利用广度优先遍历
			String cur=queue.poll();
			for(String str:nexts.get(cur)) { //遍历当前字符串对应的next字符串
				if (!set.contains(str)) {
					distances.put(str,distances.get(cur)+1);
					queue.add(str);
					set.add(str);
				}
			}
		}
		return distances;
	}
	/**
	 * 利用深度优先遍历
	 * @param cur
	 * @param to
	 * @param nexts
	 * @param distances
	 * @param solution
	 * @param res
	 */
	public static void getShortestPaths(String cur,String to,
			HashMap<String, ArrayList<String>> nexts,HashMap<String, Integer> distances,
			LinkedList<String> solution,
			List<List<String>> res) {
		solution.add(cur);
		if (to.equals(cur)) {
			res.add(new LinkedList<String>(solution));
		}else {
			for(String next:nexts.get(cur)) {
				if (distances.get(next)==distances.get(cur)+1) {
					getShortestPaths(next, to, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast();
	}

}
