package 字符串;

import java.util.ArrayList;
import java.util.List;

/*
You are playing the following Flip Game with your friend: 
Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip twoconsecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person
 will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 */
public class 翻转游戏 {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        char[] sa = s.toCharArray();
        for(int i=0; i<sa.length-1; i++) {
            if (sa[i]=='+' && sa[i+1]=='+') {
                sa[i]='-';
                sa[i+1]='-';
                results.add(new String(sa));
                sa[i]='+';
                sa[i+1]='+';
            }
        }
        return results;
    }
}
