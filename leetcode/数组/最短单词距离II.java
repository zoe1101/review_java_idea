package 数组;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
最短单词距离 的拓展，不同的是这次需要多次调用求最短单词距离的函数。
 */
public class 最短单词距离II {
/*
 * 因为会多次调用，我们不能每次调用的时候再把这两个单词的下标找出来。
 * 我们可以用一个哈希表，在传入字符串数组时，就把每个单词的下标找出存入表中。
 * 这样当调用最短距离的方法时，我们只要遍历两个单词的下标列表就行了。
 * 具体的比较方法，则类似merge two list，每次比较两个list最小的两个值，得到一个差值。
 * 然后把较小的那个给去掉。因为我们遍历输入数组时是从前往后的，所以下标列表也是有序的。
 */
	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public HashMap<String, List<Integer>> WordDistance(String[] words) {//// 统计每个单词出现的下标存入哈希表中
    	for (int i = 0; i < words.length; i++) {
    		List<Integer> count=map.get(words[i]);
    		if (count==null) {
				count=new ArrayList<Integer>();
			}
    		count.add(i);
    		map.put(words[i], count);
		}
    	return map;
    }
    public int shortest(String word1, String word2) {
    	List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;
        // 每次比较两个下标列表最小的下标，然后把跳过较小的那个
        while(i < idx1.size() && j < idx2.size()){
            distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
            if(idx1.get(i) < idx2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }
}
