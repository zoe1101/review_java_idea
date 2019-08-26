package test;

import java.util.Arrays;

/**
 * @author ZOE
 * @date 2019/8/10 10:06
 */
public class 数组练习 {
    public static void main(String[] args) {
//数组声明初始化
        //动态初始化
        int[] s1 = null; // 声明数组；
        s1 = new int[10]; // 给数组分配空间；
        for (int i = 0; i < 10; i++) {
            s1[i] = 2 * i + 1;//给数组元素赋值；
            System.out.println(s1[i]);
        }
        // 静态初始化
        int[] s2={1,2,3,4};
// 数组的遍历
//        使用循环遍历
        for (int i = 0; i <s1.length ; i++) {
            System.out.println(s1[i]);
        }
//        增强for循环for-each
//        1. for-each增强for循环在遍历数组过程中不能修改数组中某元素的值。
//        2. for-each仅适用于遍历，不涉及有关索引(下标)的操作。
        for (int i:s2){
            System.out.println(i);
        }
//        数组拷贝
        int[] s3=new int[s2.length];
        System.arraycopy(s2,0,s3,0,s2.length);
//        Arrays类的使用
        System.out.println(Arrays.toString(s3)); // 打印数组元素的值；

//        二维数组的声明
        int[][] e1=new int[3][];
        e1[0]=new int[] {1,2,3};
        e1[1]=new int[] {1,2,3,4};
        e1[2]=new int[4];
        for (int i = 0; i < e1.length; i++) {
            System.out.println(Arrays.toString(e1[i]));
        }



    }


}
