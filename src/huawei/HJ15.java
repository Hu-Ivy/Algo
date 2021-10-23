package huawei;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count+= num&1;
            num = num>>>1;

        }
        System.out.println(count);
    }
}
