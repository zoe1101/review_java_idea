package 字符串;

/**
 * 需求描述：输入一串带重复字符的字符串，输出第一次出现的字符的字符串
 * 例如：输入acvbabcd，输出结果应该是：acvbd
 * @author ZOE
 * @date 2019/9/14 20:20
 */

//方法一：利用StringBuffer + indexof
public class 字符串去重_保留第一次出现的字符 {
    public String removeRepeatChar(String str) {
        if (str==null || str.length()<2){
            return str;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            char c=str.charAt(i);
            int firstPostion=str.indexOf(c);
            int lastPosition=str.lastIndexOf(c);
            if (firstPostion==lastPosition || firstPostion==i){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

//    方法二：利用StringBuffer + 正则表达式
    public String removeRepeat(String str) {
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        return out.reverse().toString();
    }

}
