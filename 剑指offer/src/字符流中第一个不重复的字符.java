package src;
import java.util.HashMap;
/*
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

//字符流: 像流水一样的字符,一去不复返,意味着只能访问一次。
public class 字符流中第一个不重复的字符 {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    StringBuffer s = new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
        }else{
            map.put(ch, 1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return '#';
    }
}
