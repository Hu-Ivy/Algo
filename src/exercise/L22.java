package exercise;

import java.util.List;

public class L22 {
    public static void main(String[] args) {
        List<String> s = generateParenthesis(2);
        System.out.println(s.toString());
    }
    public static List<String> generateParenthesis(int n) {
        generate(0,0,2,"");
        return null;
    }

    private static void generate(int left, int right, int n, String s) {
        //terminate
        if (left==n&&right==n) {
            System.out.println(s);
            return;
        }

        //process

        //drill down
        if (left<n)
        generate(left+1,right,n,s+"(");
        if (left>right)
        generate(left,right+1,n,s+")");
        //reverse states
    }
}
