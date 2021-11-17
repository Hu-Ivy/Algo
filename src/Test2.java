import javax.swing.tree.TreeNode;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Deque<Character> stack = new ArrayDeque<>();

        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');


        char temp = stack.pop();
        System.out.println(temp);
        stack.push(temp);
        char temp2 = stack.pollLast();
        System.out.println(temp2);

    }


}
