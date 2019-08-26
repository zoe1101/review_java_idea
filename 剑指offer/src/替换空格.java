package src;
/**
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author zoe
 *
 */
public class 替换空格 {
	public String replaceSpace(StringBuffer str) {
        if(str==null || str.length()==0){
            return str.toString();
        }
        StringBuffer res = new StringBuffer();
        int index=str.length()-1;
        for (; index>=0; index--) {
			if (str.charAt(index)==' ') {
				res.append("02%");
			}else{
				res.append(str.charAt(index));
			}
		}
        return res.reverse().toString();
    }
}
