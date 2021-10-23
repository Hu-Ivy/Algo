package huawei;

import java.util.Scanner;

public class HJ108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a*b/gcd(a,b));
    }

    public static int gcd(int a, int b) {
        return b==0?a:gcd(b,a%b);
    }
}
