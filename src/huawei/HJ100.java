package huawei;

import java.util.Scanner;

public class HJ100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            int sum = 2;

            for (int i = 1; i < n; i++) {
                int num = 2+3*i;
                sum+=num;
            }
            System.out.println(sum);
        }

    }
}
