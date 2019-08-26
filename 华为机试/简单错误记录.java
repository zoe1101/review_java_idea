import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 *
 * 输出
 * fpgadrive.c 1325 1
 * @author ZOE
 * @date 2019/8/21 9:22
 */
public class 简单错误记录 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map=new LinkedHashMap<String, Integer>(); //LinkedHashMap:保证插入顺序
        int count=0;
        while (scanner.hasNext()){
            String path=scanner.next();
            int line=scanner.nextInt();
            String[] temp=path.split("\\\\"); //根据\切割
            String file=temp[temp.length-1];
            if (file.length()>16){
               file=file.substring(file.length()-16);
            }
            String key=file+" "+line;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for (String k:map.keySet()){
            count++;
            if (count>(map.keySet().size()-8)) {//输出最后八个记录
                System.out.println(k+" "+map.get(k));
            }
        }

    }
}
