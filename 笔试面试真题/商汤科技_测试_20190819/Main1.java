package 商汤科技_测试_20190819;

import java.util.Scanner;
import java.util.Stack;

/**
 * 后缀表达式求解
 * @author ZOE
 * @date 2019/8/19 19:02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s[] = sc.nextLine().toCharArray();
        Stack<Integer> calcalate_stack=new Stack<>();
        for (int i=0;i<s.length;i++){
            if (s[i]!='+' && s[i]!='-' && s[i]!='*' && s[i]!='/'){
                calcalate_stack.push(s[i]-'0');
            }else {
                int number1 = calcalate_stack.pop();
                int number2 = calcalate_stack.pop();
                int res = operate(number1, number2, s[i]);
                calcalate_stack.push(res);
            }
        }
        System.out.println(calcalate_stack.pop());
    }
    //计算
    private static int operate(int number1, int number2, char operator) {
        if (operator == '+'){ return number2 + number1;}
        if (operator == '-'){return number2 - number1;}
        if (operator == '*'){return number2 * number1;}
        if (operator == '/'){return number2 / number1;}
        return 0;
    }
}
