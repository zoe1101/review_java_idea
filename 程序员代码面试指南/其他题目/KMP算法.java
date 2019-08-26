package 其他题目;

public class KMP算法 {

	private static int getIndexOf(String str, String match) {
		if (str==null || match==null || match.length()<1 || str.length()<match.length()){
			return -1;
		}
		char[] ss=str.toCharArray();
		char[] ms=match.toCharArray();
		int i=0;
		int j=0;
		int[] next=getNextArray(ms);
		while (i<ss.length && j<ms.length){
			if (ss[i]==ms[j]){//匹配上了，一起++
				i++;
				j++;
			}else if (next[j]==-1){//模式串开头都匹配不上，主串定位++
					i++;
			}else { //前缀存在，则调到前缀结尾的后一个的位置，即next[j]
				j=next[j];
			}
		}
		return j==ms.length?i-j:-1; //模式串的定位指针已经到了末尾，表示匹配成功

	}

	private static int[] getNextArray(char[] ms) {
		if (ms.length==1){
			return  new int[] {-1};
		}
		int[] next=new int[ms.length];
		next[0]=-1;
		next[1]=0;
		int pos=2;
		int count=0;
		while (pos<next.length){
			if (ms[pos-1]==ms[count]){ //最长前缀和后缀
				next[pos++]=++count;
			}else if (count>0){
				count=next[count];
			}else {
				next[pos++]=0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
