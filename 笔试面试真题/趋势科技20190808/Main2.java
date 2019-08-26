package 趋势科技20190808;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 有面值为1元，5元，10元，20元，50元，100元的纸币，在给定每种纸币数量的情况下，求问有多少中方式组合出M元。
 * @author ZOE
 * @date 2019/8/8 21:04
 */
public class Main2 {
    public static void main(String[] args) {
        String s1="6 5 4 3 2 1";
        String s2="11";
        String[] temp=s1.trim().split(" ");
        int m=Integer.parseInt(s2);
        System.out.println(" m : "+m);
        int[] nums=new int[temp.length];
        for (int i=0;i<temp.length;i++){
            nums[i]=Integer.parseInt(temp[i]);
            System.out.println(" num[i] : "+nums[i]);
        }

        int[] money={1,5,10,20,50,100};//纸币面额

        int count = 0; //符合条件的组合次数

        for (int i = 0; i <=nums[5]; i++) {
            //100元可能出现的张数
            for (int j = 0; j <=nums[4]; j++) {
                //50元可能出现的张数
                for (int k = 0; k <= nums[3]; k++) {
                    //20元可能出现的张数
                    for (int l = 0; l <= nums[2]; l++) {
                        //10元可能出现的张数
                        for (int n = 0; n <= nums[1]; n++) {
                            int o = m- (i * money[5] + j * money[4] + k * money[3] + l * money[2] + n * money[1]); //1元的数量
                            int sum = i * money[5] + j * money[4] + k * money[3] + l * money[2] + n * money[1] + o * money[0];
                            if (sum == m && o>=0 &&o<=nums[0]) {
                                System.out.println(" sum : "+sum);
                                System.out.println(i+" "+j+" "+k+" "+l+" "+n+" "+o);
                                count+=(i+j+k+l+n+o);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
