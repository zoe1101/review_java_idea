package 数组;
/*
给定单词list，返回其中任意两单词的最短位置距离。

example：
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

假定两个单词不同，而且都在数组中。
 */
public class 最短单词距离 {
	public static int shortestDistance(String[] words, String word1, String word2) {  
		int p1=-1;
		int p2=-1;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1=i;
			}else if (words[i].equals(word2)) {
				p2=i;
			}
			if (p1!=-1 && p2!=-1) {
				min=Math.min(min, Math.abs(p2-p1));
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String[] words= {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestDistance(words,"coding","makes"));
	}

}
