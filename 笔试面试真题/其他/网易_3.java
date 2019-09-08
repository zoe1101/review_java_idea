package 其他;

import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/7 19:29
 */
public class 网易_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int[] res=new int[t];
        for (int i=0;i<t;i++){
            int k=scanner.nextInt();
            int m=scanner.nextInt();
            int[] marr=new int[m];

            for (int j = 0; j <m ; j++) {
                marr[j]=scanner.nextInt();
            }

            int count;
            if (marr.length==0){
                count=30/(k+1); //保证k+1天喝一次。
            }else {
                count=m; //初始次数为 m
                count+=(marr[0]-1)/(k+1);
                if (marr.length>1){
                    for (int j = 1; j <m ; j++) {
                        if (marr[j]-marr[j-1]>(k+1)){
                            count+=(marr[j]-marr[j-1]-1)/(k+1);
                        }
                    }
                }
                count+=(30-marr[marr.length-1])/(k+1);
            }
            res[i]=count;
        }
        for (int r:res) {
            System.out.println(r);
        }

    }
}
