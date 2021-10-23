package huawei;

import java.util.Scanner;
//斐波那契数列
public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getTotalCount(n));
        }
    }

    private static int getTotalCount(int n) {
        if (n<3) return 1;

        return getTotalCount(n-1)+getTotalCount(n-2);
    }
}
