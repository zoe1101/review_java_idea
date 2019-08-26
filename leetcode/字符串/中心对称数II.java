package 字符串;

import java.util.ArrayList;
import java.util.List;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:
Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.

 */
public class 中心对称数II {
	private char[] self = {'0', '1', '8'};
    private char[] pair = {'0', '1', '6', '8', '9'};
    private char[] strobo = {'0', '1', ' ', ' ', ' ', ' ', '9', ' ', '8', '6'};
    private void find(char[] buf, boolean zero, int step, List<String> results) {
        if ((step<<1) == buf.length) {
            for(int i=step, j=step-1; i<buf.length; i++, j--) buf[i] = strobo[buf[j]-'0'];
            results.add(new String(buf));
            return;
        } else if ((step<<1) == buf.length-1) {
            for(int i=step+1, j=step-1; i<buf.length; i++, j--) buf[i] = strobo[buf[j]-'0'];
            for(int i=0; i<self.length; i++) {
                buf[step] = self[i];
                results.add(new String(buf));
            }
            return;
        }
        for(int i=0; i<pair.length; i++) {
            if (buf.length>1 && zero && pair[i]=='0') continue;
            buf[step] = pair[i];
            find(buf, false, step+1, results);
        }
    }
    
    public List<String> findStrobogrammatic(int n) {
        List<String> results = new ArrayList<>();
        find(new char[n], true, 0, results);
        return results;
    }

}
