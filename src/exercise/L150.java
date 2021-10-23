package exercise;

import java.util.Deque;
import java.util.LinkedList;

public class L150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        int res = evalRPN(tokens);
        System.out.println(res);

    }
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }else {
                int num1=stack.pop();
                int num2=stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }
    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }


}
