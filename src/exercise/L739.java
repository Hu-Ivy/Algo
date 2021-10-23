package exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L739 {
    public static void main(String[] args) {
        int[] tempera = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(tempera);

        System.out.println(Arrays.toString(res));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i-temp;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            res[temp] = 0;
        }

        return res;
    }
}
