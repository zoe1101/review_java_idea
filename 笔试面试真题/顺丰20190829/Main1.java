package 顺丰20190829;

import com.sun.javaws.IconUtil;

import java.util.*;

/**
 * @author ZOE
 * @date 2019/8/29 19:47
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();  //人数
            int m=scanner.nextInt();  //语言数
            int k=scanner.nextInt(); //已知信息数
            int[][] info=new int[k][2];
            Map<Integer,Integer> perMapLang=new HashMap<>();
            Map<Integer,Integer> langMapCount=new HashMap<>();
            if (k==0){
                System.out.println(n);
                continue;
            }
            for (int i = 0; i <k ; i++) {
                info[i][0]=scanner.nextInt();
                info[i][1]=scanner.nextInt();
                perMapLang.put(info[i][0],langMapCount.getOrDefault(info[i][1],0));
                langMapCount.put(info[i][1],langMapCount.getOrDefault(info[i][1],0)+1);
            }
            //有n次学习机会
            if (langMapCount.size()==1){ //目前只学习了一种语言
                int v=0;
                for (Map.Entry<Integer,Integer> entry:langMapCount.entrySet()){
                    v=entry.getValue();
                }
                System.out.println(n-v);
                continue;
            }

            int needStudy=0; //需要学习机的数量
            for (int i=1;i<=m;i++){
                if (langMapCount.containsKey(i) && langMapCount.get(i)==1){ //当有一种语言只有一个人会时
                    needStudy++;
                }
            }
            if (needStudy+langMapCount.size()<n){
                needStudy+=n-(needStudy+langMapCount.size());
            }

            System.out.println(needStudy);
        }
    }
}
