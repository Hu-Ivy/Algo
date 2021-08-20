package sort;

import java.util.Arrays;

public class Insert {
    static int[] arr = {3, 9, -1, 10, -2};

    public static void main(String[] args) {
        int[] arr2 = {3, 9, -1, 10, -2};
        ;
        insertSort(arr2);

        for (int item :
                arr2) {
            System.out.println(item);
        }
    }

    public static void insertSort(int[] arr) {
        int insertValue;
        int insertIndex;//index+1位置指向的是要插入的位置。index指向的是比较的位置。大数后移，index--。
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
            System.out.print("第" + i + ":");
            System.out.println(Arrays.toString(arr));
        }
    }
}
