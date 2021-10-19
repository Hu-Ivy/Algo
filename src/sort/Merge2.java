package sort;

import java.util.Arrays;

public class Merge2 {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) return;
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int index = mid + 1;
        int l = left;

        int i=left;
        while (l <= mid && index <= right) {
            if (arr[l] <= arr[index]) {
                temp[i] = arr[l++];

            } else {
                temp[i] = arr[index++];
            }
            i++;
        }
        while (l <= mid) {
            temp[i] = arr[l++];
            i++;
        }
        while (index <= right) {
            temp[i] = arr[index++];
            i++;
        }


        for (int j = left; j < right + 1; j++) {
            arr[j] = temp[j];
        }

    }
}
