import java.util.Scanner;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复

 * 说明:长度超过2的子串

 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 * @author ZOE
 * @date 2019/8/21 9:44
 */
public class 密码验证合格程序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
//          判断是否满足：长度超过8位
            if (str==null || str.length()<=8){
                System.out.println("NG");
                continue;
            }
//          判断是否满足： 包括大小写字母.数字.其它符号,以上四种至少三种
            int digit=0;
            int upcase=0;
            int lowcase=0;
            int elsechar=0;
            for (int i = 0; i <str.length() ; i++) {
                if (str.charAt(i)>='0' && str.charAt(i)<='9' ){
                    digit=1;
                }else if (str.charAt(i)>='a' && str.charAt(i)<='z' ){
                    lowcase=1;
                }else if (str.charAt(i)>='A' && str.charAt(i)<='Z' ){
                    upcase=1;
                }else {
                    elsechar=1;
                }
            }
            if (digit+upcase+lowcase+elsechar<3){
                System.out.println("NG");
                continue;
            }
//          判断是否满足：  不能有相同长度超2的子串重复
            boolean repeatstr=false;
            for (int i = 0; i <str.length()-2 ; i++) {
                String sbustr=str.substring(i,i+3);
                if (str.substring(i+1).contains(sbustr)){
                    repeatstr=true;
                    break;
                }
            }
            if (repeatstr){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
