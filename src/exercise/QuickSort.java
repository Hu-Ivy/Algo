package exercise;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
    static int[] arr2 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot, i, j, temp;
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

            if (i<j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }


        }


        arr[left] = arr[i];
        arr[i] = pivot;

        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);

    }
}
