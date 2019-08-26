package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZOE
 * @date 2019/8/20 18:45
 */

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> files=new ArrayList<>();
        ArrayList<String> lines=new ArrayList<>();
        int count=0;
        while (scanner.hasNext()){
            String input=scanner.nextLine();
            String[] strs=input.split(" ");
            if (strs.length<2){
                files.add(strs[0]);
                continue;
            }
            String[] temp=strs[0].split("\\\\");
            String file=temp[temp.length-1];
            files.add(file);
            for (int i=1;i<strs.length;i++){
                lines.add(strs[i]);
            }
            count+=(strs.length-1);
        }

    }

}
