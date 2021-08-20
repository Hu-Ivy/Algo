package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Quick {
    static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
    static int[] arr2 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

    public static void main(String[] args) {
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i, j, temp, pivot;
        i = left;
        j = right;

        pivot = arr[left];
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }

            //小于才交换，否则相等的话不用交换
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }


        }

        arr[left] = arr[i];
        arr[i] = pivot;

        QuickSort(arr, left, j - 1);
        QuickSort(arr, j + 1, right);
    }
}
