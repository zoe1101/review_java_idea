package 拼多多20190728;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] words=string.split("\\s+");
        int[] a=new int[27];
        for (String word:words) {
            char first=word.charAt(0);
            char last=word.charAt(word.length()-1);
            a[first-'A']++;
            a[last-'A']++;
        }
        for (int num:a) {
            if ((num>0 && num%2==0) || num==0) {
                continue;
            }else {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

}
