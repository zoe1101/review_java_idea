package 字节跳动后端316;

import java.util.ArrayList;
import java.util.Scanner;
/*
第二题:
	1.三个同样的字母连在一起，一定是拼写错误，去掉一个就好了。比如:helllo --> hello
	2.两对一样的字母(AABB型)连在一起，一定是拼写错误，去掉第二对的第一个字母。比如:helloo --> hello
	3.上面的规则优先“从左到右”匹配，即如果是AABBCC型，应优先考虑修复AABB为AABCC。
*/
//解题思路：扫描，从前向后不断更新，匹配规则以后去掉字母就可以
public class main2 {
    public static String modify(String s) {
        ArrayList<Character> list = new ArrayList<>(); //利用动态数组存储,存储修正后的字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = list.size();
            if (size < 2) {
                list.add(c);
                continue;
            }
            if (size >=2 && c == list.get(size - 1) && c == list.get(size - 2)) {//满足连续三个字符相同的情况,忽略当前字符，不写入
                continue;
            }
            if (size >= 3 && c == list.get(size - 1) && list.get(size - 2) == list.get(size - 3)) { //满足AABB型,忽略当前字符，不写入
                continue;
            }
            list.add(c);
        }

        String ans = "";
        for (int i = 0; i <list.size(); i++) {
            ans += list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine()); //需要修正的字符串个数
        for (int i = 0; i <num; i++) {
            System.out.println(modify(s.nextLine()));
        }
        s.close();

    }

}
