package huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HJ101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i]=sc.nextInt();
        }
        int sort=sc.nextInt();

        if (sort==0) {
            Arrays.sort(array);
        }else {
            Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }

        for (int num :
                array) {
            System.out.print(num+" ");
        }
    }
}
