package sort;

import java.util.Arrays;

public class Select {
    static int[] arr = {3, 9, -1, 10, -2};
    static int[] arr2 = {1, 3, 2, 4, 5};

    public static void main(String[] args) {
        selectSort(arr2);
        for (int item :
                arr2) {
            System.out.println(item);
        }
    }

    public static void selectSort(int[] arr) {
        int min;
        int index;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }


        }
    }
}
