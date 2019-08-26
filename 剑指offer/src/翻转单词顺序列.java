package src;
/**
 *牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 *例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author zoe
 *
 */
public class 翻转单词顺序列 {
	//先整体反转,在以空格为切分,将每个单词进行反转。
    public String ReverseSentence(String str) {
        if(str==null || str.trim().length()==0) {
        	return str;
        }
        char[] chas=str.toCharArray();
        reverse(chas, 0, chas.length-1);
        
        int start = 0;//记录每个单词的起始位置
        for(int i=0;i<chas.length;i++) {
        	if(chas[i]==' ') {
        		reverse(chas, start, i-1);
        		start=i+1;
        	}else if (i==chas.length-1) {
				reverse(chas, start, chas.length-1);
			}
        }
        return new String(chas);
        
    }
    
    private static void reverse(char[] chas,int start,int end) {
		while (start<end) {
			swap(chas, start, end);
			start++;
			end--;
		}
	}
    private static void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
      }
}
