package exercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class L316 {
    public static void main(String[] args) {
        String s = "bcabc";
        String res = removeDuplicateLetters(s);

        System.out.println(res);
    }
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len<2) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i]-'a']=i;
        }

        Deque<Character> stack = new ArrayDeque<>(len);
        boolean[] visited = new boolean[26];

        for (int i = 0; i <len; i++) {
            char currentChar = charArray[i];
            if (visited[currentChar-'a']) {
                continue;
            }
            //栈不为空且现在的字符比上一个小，且上一个字符后面还会出现，则弹出上一个。
            while (!stack.isEmpty()&&currentChar<stack.peek()&&lastIndex[stack.peek()-'a']>i) {
                char top = stack.pop();
                visited[top-'a'] = false;
            }

            stack.push(currentChar);
            visited[currentChar-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    public static String removeDuplicateLetters2(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    //如果还剩下上一个字符，则可以去掉
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

}
