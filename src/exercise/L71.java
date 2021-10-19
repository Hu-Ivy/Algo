package exercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class L71 {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String path2 = "/../";
        String res = simplifyPath(path2);
        System.out.println(res);
    }
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        String res;
        if (paths.length==0) {
            return "/";
        }

        Deque<String> stack = new ArrayDeque<>();
        for (String s : paths) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.insert(0, "/");
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");

        }

        return sb.toString();
    }
}
