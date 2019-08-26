package IO技术;
import java.io.*;
public class 输入输出 {
    public static void main(String[] args) {
    	FileInputStream fis=null;
        try {
            //创建输入流
            fis = new FileInputStream("D:/review/review_java/java基础/IO技术/a.txt"); // 文件内容是：abc
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            //当temp等于-1时，表示已经到了文件结尾，停止读取
            while ((temp = fis.read()) != -1) {
                sb.append((char) temp);
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //这种写法，保证了即使遇到异常情况，也会关闭流对象。
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
