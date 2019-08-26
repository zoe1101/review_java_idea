package 科大讯飞_测试_20190816;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/16 18:53
 */
public class Main2 {
    public static int query(int[] arr,int target) {
        if (arr==null || arr.length==0 || arr[arr.length-1]<target || arr[0]>target){
            return -1;
        }
        return process(arr,target,0,arr.length-1);

    }

    private static int process(int[] arr,int target, int left, int right) {
        if (left>right){
            return -1;
        }
        int mid=left+((right-left)>>1);
        if (arr[mid]==target){
            return mid+1;
        }else if (arr[mid]>target){
            process(arr,target,left,mid-1);
        }else {
            process(arr,target,mid+1,right);
        }
        return -1;
    }

    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        ArrayList<> list=new ArrayList();
//        while (scanner.hasNext()){
//            list.add(scanner.nextInt());
//        }
        int[] arr={11,13,15,17,19,23};
        System.out.println(query(arr,19));


    }
}
