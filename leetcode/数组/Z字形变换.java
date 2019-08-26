package 数组;
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * @author zoe
 *
 */

/*
 找规律：
1、每一个Z字的首字母差，numRows*2-2 位置
2、除去首尾两行，每个 Z字有两个字母，索引号关系为，一个为 i，另一个为 numsRows*2-2-i
 */
//这里其实是N字型
public class Z字形变换 {
	public String convert1(String s, int numRows) {
        //字符串转化成数组
        char[] c = s.toCharArray();
        //创建字符串数组
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        int len = c.length;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(c[i++]);
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--)
                sb[idx].append(c[i++]);
        }
        //拼接所有字符串
        for(int idx = 1;idx < numRows;idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
	
	/*对方法1的优化
	 按行排序，对字符串遍历，每行一次插入相应的字符。 
	通过构造一个与字符串长度相等的数组 chas 用于存储转换后的字符顺序。
	构建一个长度为numRows的数组存储每一行下一次的插入下标。
	计算初始下标之后，依次插入字符即可。
	*/
    public String convert2(String s, int numRows) {
        if (numRows==1) {
			return s;
		}
        int[] rowIndex=new int[numRows];//记录每一行的起始坐标值
        char[] chas=new char[s.length()];
        int n=0;
        int burketSize=numRows*2-2; //相邻N的首字母的差值
        int burketNum = chas.length/burketSize;  //有多少个完整的N
        int rem = chas.length % burketSize; //最后一个不完整的N中包含的字符数
        for(int i = 1; i < numRows; i ++){
        	int flag=i==1?1:2;
        	//n:第i-1行的字母个数
        	n=flag*burketNum+(rem >= i ? ( 1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
        	rowIndex[i] = rowIndex[i-1] + n; //第i行首字母的索引值
        }
        int flag=-1;
        int curRow = 0;
        for(char c : s.toCharArray()){
        	chas[rowIndex[curRow]] = c;
        	rowIndex[curRow] = rowIndex[curRow] + 1;
        	 if (curRow == 0 || curRow == numRows - 1) flag = -flag;
             curRow += flag;
        }
        return new String(chas);
    }
}
