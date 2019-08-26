package 京东20190824;

import java.util.Scanner;

/**
 * 输入一个字符串，键盘按键Caps Lock可以切换大小写模式，在大写模式下，若想输入小写字母，可以shift+字母，同样在小写模式下，若想输入大写字母可以shift+字母，给定一个字符串求最小的点按键击次数。注意：shift+字母算两次按键点击，默认初始状态是小写模式。
 * @author ZOE
 * @date 2019/8/24 20:51
 */
public class Main1 {
    /*
     * 分析：设定一个boolean，变量flag，表示大小写模式，若flag = true是大写模式，若是false则是小写模式。可以遍历字符串，每次判断字母大小写，下一个字母状态和flag状态。用一个变量res，记录最少的次数。
     * 情况一：若当前字母小写，且处在小写模式（flag == false），则次数直接加一。
     * 情况二：若当前字母小写，且处在大写模式（flag == true），则判断下一个字母大小写。若下个字母小写则需先将状态切换到小写（因为连续两个小写字母情况，如果连续两个shift+字母的点击次数（四次）比先切换到小写状态，再输入两个小写字母（3次）的次数大)。若下个字母大写，则不用切换状态，而用shift+字母。
     * 情况三：若当前字母大写，且处在大写模式（flag == true），则次数直接加一。
     * 情况四：若当前字母大写，且处在小写模式（flag == false），则判断下一个字母大小写。若下个字母大写则需先将状态切换到大写（因为连续两个大写字母情况，如果连续两个shift+字母的点击次数（四次）比先切换到大写状态，再输入两个大写字母（3次）的次数大)。若下个字母小写，则不用切换状态，而用shift+字母。

     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String str=scanner.next();
        char[] chas=str.toCharArray();
        int count=0;
        boolean flag=false; //表示当前是否是大写模式
        for (int i = 0; i <chas.length ; i++) {
            if (chas[i]>='a' && chas[i]<'z'&& flag==false){ //待输入字母小写，且为小写模式
                count++;
            }else if (chas[i]>='a' && chas[i]<='z' && flag==true){//待输入字母小写，且为大写模式
                if (i+1<chas.length){
                    if (chas[i+1]>='a' && chas[i+1]<='z'){ //下一个字母是也是小写，就用shift+x的方式
                        flag=false;
                        count+=2;
                    }else {//下一个字母是大写，就用caps lock的方式,flag变为true,大写模式
                        count+=2;
                    }
                }else { //最后一个字母
                    count+=2;
                }
            }else if (chas[i]>='A' && chas[i]<='Z' && flag==true) {//待输入字母大写，且为大写模式
                count++;
            }else if (chas[i]>='A' && chas[i]<='Z' && flag==false){//待输入字母大写，且为小写模式
                if (i+1<chas.length){
                    if (chas[i+1]>='A' && chas[i+1]<='Z'){//下一个字母是也是大写，就用shift+x的方式
                        flag=true;
                        count+=2;
                    }else {//下一个字母是小写，就用caps lock的方式,flag变为false,小写模式
                        count+=2;
                    }
                }else { //最后一个字母
                    count+=2;
                }
            }
        }
        System.out.println(count);
    }


}
