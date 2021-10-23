package huawei;

import java.io.*;
import java.util.Scanner;

public class HJ53 {
    private static int[] arr = {2, 3, 2 ,4};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num<3){
                System.out.println(-1);
            }else if (num%4==1||num%4==3) {
                System.out.println(2);
            }else if (num%4==2) {
                System.out.println(4);
            }else if (num%4==0) {
                System.out.println(3);
            }
        }

    }


}
