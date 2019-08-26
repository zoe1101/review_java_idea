package 其他题目;

/**
 * 在字符串的最后添加最少的字符，使得整个字符串都成为回文串
 * @author ZOE
 * @date 2019/8/7 16:59
 */
public class 通过添加字符得到回文串 {
    public static char[] manacherString(String str){
        char[] chas=str.toCharArray();
        char[] res=new char[str.length()*2+1];
        int index=0;
        for (int i = 0; i < chas.length; i++) {
            res[index++]='#';
            res[index++]=chas[i];
        }
        res[index]='#';
        return  res;
    }

    public static String shortestEnd(String str) {
        if (str==null ||str.length()==0){
            return null;
        }
        char[] chas=manacherString(str);
        int[] pArr=new int[chas.length];
        int index=-1;
        int pR=-1;
        int maxContainEnd=-1;
        for (int i = 0; i <chas.length ; i++) {
            pArr[i]=pR>i?Math.min(pArr[2*index-i],pR-i):1;
            while (i+pArr[i]<chas.length && i-pArr[i]>-1){
                if (chas[i+pArr[i]]==chas[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if (i+pArr[i]>pR){
                pR=i+pArr[i];
                index=i;
            }
            if (pR==chas.length){ //右边界到达字符串最后一个字符，找到了包含最后一个字符的最长回文子串
                maxContainEnd=pArr[i];
                break;
            }
        }
        char[] res=new char[str.length()-maxContainEnd+1];
        for (int i = 0; i <res.length ; i++) {
            res[res.length-1-i]=chas[i*2+1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str="abcd123321";
        System.out.println(shortestEnd(str));
    }
}
