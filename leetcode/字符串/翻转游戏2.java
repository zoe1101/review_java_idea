package 字符串;
/*
ou are playing the following Flip Game with your friend: Given a string that contains 
only these two characters: + and -, you and your friend take turns to flip 
two consecutive "++" into "--". The game ends when a person can no longer make a 
move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:

Input: s = "++++"
Output: true 
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
Follow up:
Derive your algorithm's runtime complexity.
 */
public class 翻转游戏2 {
	public boolean canWin(String s) {
        for (int i = -1; (i = s.indexOf("++",i+1)) >= 0;) {
            if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                return true;
            }
        }
        return false;
    }
}
