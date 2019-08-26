import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:25
 */
public class 坐标移动 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String str=scanner.nextLine();
            String[] strs=str.trim().split(";");
            int x=0,y=0;
            for (String s:strs){
                if (s.charAt(0)=='A' && s.substring(1).matches("[0-9]+")){
                    x-=Integer.parseInt(s.substring(1));
                }
                if (s.charAt(0)=='D' && s.substring(1).matches("[0-9]+")){
                    x+=Integer.parseInt(s.substring(1));
                }
                if (s.charAt(0)=='W' && s.substring(1).matches("[0-9]+")){
                    y+=Integer.parseInt(s.substring(1));
                }
                if (s.charAt(0)=='S' && s.substring(1).matches("[0-9]+")){
                    y-=Integer.parseInt(s.substring(1));
                }
            }
            System.out.println(x+","+y);

        }
    }
}
