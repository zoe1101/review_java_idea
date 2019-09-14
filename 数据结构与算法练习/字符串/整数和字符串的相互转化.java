package 字符串;

/**
 * @author ZOE
 * @date 2019/9/13 21:29
 */
public class 整数和字符串的相互转化 {
    public static String intToStr(int n) {
//        return String.valueOf(n);

        StringBuilder stringBuilder=new StringBuilder();
       while (n!=0){
           stringBuilder.append(n%10 +"0");
           n/=10;
       }
       if (n<0){
           stringBuilder.append('-');
       }
        return stringBuilder.reverse().toString();

    }

    public static int strToInt(String str) {
//        return Integer.parseInt(str);
        int n=0;
        int len=str.length();
        //处理正负
        boolean neg=false;
        if (len<2 && str.charAt(0)!='+' && str.charAt(0)!='-'){
            return str.charAt(0)-'0';
        }

        if (str.charAt(0)=='-'){
            neg=true;
        }
        if (neg) {
            int index = 1;
            while (index < len) {
                int c = str.charAt(index) - '0';
                n = n * 10 + c;
                index++;
            }
        }else {
            int index = 0;
            while (index < len) {
                int c = str.charAt(index) - '0';
                n = n * 10 + c;
                index++;
            }
        }
        return neg?-n:n;
    }

    public static void main(String[] args) {
        System.out.println(intToStr(22));
        System.out.println(strToInt("-563"));
    }
}
