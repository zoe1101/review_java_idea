package 字符串;
/*
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。

示例 1:
输入: 1
输出: "1"

示例 2:
输入: 4
输出: "1211"

 */

//对前一个报数的处理
public class 报数 {
    public String countAndSay(int n) {
    	if (n > 1) {
    		//得到序列n-1对应的字符串temp，将其转换为字符数组。
    		//新建一个StringBuilder类型的变量stringBuilder用以保存结果。
    		String temp = countAndSay(n - 1);
    		StringBuilder builder = new StringBuilder();
    		//对于temp中的每一个字符，寻找其后与其相同的字符数（包含它自己）index，根据index来跳跃遍历temp。
    		//以5：111221为例
    		char pre = temp.charAt(0); //最前面的字符，1
            int count = 1;
            for (int i = 1; i < temp.length(); i++) { //遍历n-1剩下的字符
                char str = temp.charAt(i);
                if (str == pre) {
                    ++count;
                } else {
                    builder.append(count).append(pre);
                    pre = temp.charAt(i);
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            return builder.toString();
    	}
    	return "1";
    	
    }
}
