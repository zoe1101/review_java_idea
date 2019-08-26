package 趋势科技20190808;

import java.util.Arrays;

/**
 * @author ZOE
 * @date 2019/8/8 20:11
 */
//两个超长非负数字字符串求和
public class Main1 {
    public static void main(String[] args) {
        String str1="12.61";
        String str2="123.61";
        String[] str1s=str1.trim().split("\\.");
        String[] str2s=str2.trim().split("\\.");
        String str11=str1s[0];
        String str21=str2s[0];
        String str12=str1s.length>1?str1s[1]:"0";
        String str22=str2s.length>1?str2s[1]:"0";
//        System.out.println(str11+" "+str12+" "+str21+" "+str22);
        //整数部分与小数部分分开计算
        //小数部分计算
        StringBuilder sb2=new StringBuilder();
        int carry=0;
        String longs=str12.length()>str22.length()?str12:str22;
        String shorts= longs.equals(str12) ?str22:str12;

        for (int i=longs.length()-1;i>=0;i--){
            if (i<shorts.length()){
                int cursum=(shorts.charAt(i)-'0')+(longs.charAt(i)-'0')+carry;
                carry=cursum/10;
                sb2.append(cursum%10);
            }else{
                int cursum=(longs.charAt(i)-'0')+carry;
                carry=cursum/10;
                sb2.append(cursum%10);
            }
        }
        String s2=sb2.reverse().toString(); //整数部分和
        System.out.println(s2);

        //整数部分计算
        StringBuilder sb1=new StringBuilder();
        longs=str11.length()>str21.length()?str11:str21;
        shorts= longs.equals(str11) ?str2:str11;

        for (int i=longs.length()-1;i>=0;i--){
            if (i>=longs.length()-shorts.length()){
                int cursum=(shorts.charAt(i-shorts.length()+1)-'0')+(longs.charAt(i)-'0')+carry;
                carry=cursum/10;
                sb1.append(cursum%10);
            }else{
                int cursum=(longs.charAt(i)-'0')+carry;
                carry=cursum/10;
                sb1.append(cursum%10);
            }
        }
        //有进位
        if (carry==1){
            sb1.append(1);
        }
        String s1=sb1.reverse().toString(); //整数部分和
        System.out.println(s1);

        String res;
        if (s2.length()==0){
            res=s1;
        }else{
            res=s1+"."+s2;
        }
        System.out.println(res);



    }


}
