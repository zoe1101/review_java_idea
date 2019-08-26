package 数组;
/*
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1. 
Given word1 = "makes", word2 = "makes", return 3.
Note: You may assume word1 and word2 are both in the list.

这题和I是一样的，唯一不同的是对于word1和word2相同的时候，我们要区分第一次遇到和第二次遇到这个词。
这里加入了一个turns，如果是相同单词的话，每次遇到一个单词turn加1，这样可以根据turn来判断是否要switch。
 */
public class 最短单词距离III {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int idx1=-1;
		int idx2=-1;
		int distance=Integer.MAX_VALUE;
		int turns=0;
		int inc= (word1.equals(word2) ? 1 : 0); //word1与word2是否相同
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) && turns%2==0) { //word1后遇到
				idx1=i;
				if (idx2!=-1) { //前面已经有word2
					distance=Math.min(distance,idx1-idx2);
				}
				turns+=inc;
			}else if(words[i].equals(word2)){//word2后遇到
				idx2=i;
				if (idx1!=-1) { //前面已经有word1
					distance=Math.min(distance,idx2-idx1);
				}
				turns+=inc;
			}
		}
		return distance;
		
	}

}
