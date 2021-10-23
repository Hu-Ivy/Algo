package huawei;

import java.util.Scanner;

public class HJ12 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String a=in.next();
        reverse(a.toCharArray());
    }

    public static void reverse(char[] s) {
        for (int i = s.length-1; i >=0 ; i--) {
            System.out.print(s[i]);

        }
        System.out.println();
    }
}
