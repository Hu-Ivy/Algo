package exercise;

import java.util.Deque;
import java.util.LinkedList;

public class JZ21 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};

        boolean res = IsPopOrder(pushA,popA);
        System.out.println(res);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Deque<Integer> stack = new LinkedList<>();

        int pushIndex = 0;
        int popIndex = 0;

        while (pushIndex<pushA.length) {
            if (!stack.isEmpty()&&stack.peek()==popA[popIndex]) {
                stack.pop();
                popIndex++;
            }else {
                stack.push(pushA[pushIndex]);
                pushIndex++;

            }

        }

        while (!stack.isEmpty()&&stack.peek()==popA[popIndex]) {
            stack.pop();
            popIndex++;
        }

        return stack.isEmpty();
    }

}
