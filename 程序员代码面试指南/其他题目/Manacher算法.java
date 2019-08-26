package 其他题目;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ZOE
 * @date 2019/8/7 15:22
 */
public class Manacher算法 {
    public static char[] manacherString(String str){
        char[] chas=str.toCharArray();
        char[] res=new char[str.length()*2+1];
        int index=0;
        for (int i = 0; i < chas.length; i++) {
            res[index++]='#';
            res[index++]=chas[i];
        }
        res[index]='#';
        return  res;
    }

    public static int maxLcpsLength(String str) {
        if (str==null || str.length()==0){
            return 0;
        }
        char[] chas=manacherString(str);
        //回文半径数组，pArr[i]:以i位置上的字符（chas[i]）作为回文中心的情况下，扩出去得到的最大回文半径是多少
        int[] pArr=new int[chas.length];
        //最右回文右边界的对称中心,表示最近一次更新pR时，那个回文中心的位置
        int index=-1;
        //最右回文右边界，表示之前遍历的所有字符的所有回文半径中，最右即将到达的位置
        int pR=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <chas.length ; i++) {
            pArr[i]= pR>i ? Math.min(pArr[2*index-i],pR-i) : 1;
            while (i+pArr[i]<chas.length && i-pArr[i]>-1){ //边界在字符串范围内
                if (chas[i+pArr[i]]==chas[i-pArr[i]]){ //相等，进行边界扩充
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>pR){ //当前回文边界超出最右回文右边界，更新最右回文右边界与对称中心
                pR=i+pArr[i];
                index=i;
            }
            max=Math.max(max,pArr[i]); //选取回文半径最大的值作为最长回文子串长度
        }
        return max-1;
    }

    public static void main(String[] args) {
        String str1="123";
        System.out.println(maxLcpsLength(str1));
        String str2="abc1234321ab";
        System.out.println(maxLcpsLength(str2));
    }

}
