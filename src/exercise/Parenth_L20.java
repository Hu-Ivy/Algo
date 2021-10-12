package exercise;

import java.util.*;

public class Parenth_L20 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果预见的是右括号，则判断是否有对应的左括号，有就pop。没有就返回false。
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty()||stack.peek()!=pairs.get(ch)) {
                    return false;
                }else {
                    stack.pop();
                }
            }
            stack.push(ch);
        }

        return stack.isEmpty();
    }
}
