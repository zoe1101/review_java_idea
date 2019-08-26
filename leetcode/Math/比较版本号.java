package Math;
/*
比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
你可以假设版本字符串非空，并且只包含数字和 . 字符。
 . 字符不代表小数点，而是用于分隔数字序列。
例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和
第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 

示例 1:
输入: version1 = "0.1", version2 = "1.1"
输出: -1

示例 2:
输入: version1 = "1.0.1", version2 = "1"
输出: 1

 */
public class 比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] ver1=version1.trim().split("\\.");
        String[] ver2=version2.trim().split("\\.");
        int i=0;
        for (; i < ver1.length && i < ver2.length; i++) {
			Integer num1=Integer.parseInt(ver1[i]);
			Integer num2=Integer.parseInt(ver2[i]);
			if (num1>num2) {
				return 1;
			}else if (num1<num2) {
				return -1;
			}
		}
        while (i<ver1.length) {
			Integer num1=Integer.parseInt(ver1[i]);
			if (num1!=0) {
				return 1;
			}
			i++;
		}
        
        while (i<ver2.length) {
			Integer num2=Integer.parseInt(ver2[i]);
			if (num2!=0) {
				return -1;
			}
			i++;
		}
        return 0;
    }
}
