package exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class L20 {
    public static void main(String[] args) {
        String s = "){";
        boolean res = isValid(s);

        System.out.println(res);
    }

    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        if (chars.length <= 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for (char c :
                chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    //
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
