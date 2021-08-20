package search;

public class Binary {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 11, -1, 34, 89};
        int index = biSearch(arr, 0, arr.length - 1, 99);
        System.out.println(index);
    }

    public static int biSearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left>right) {
            return -1;
        }
        if (value == arr[mid]) {
            return mid;
        } else if (value < arr[mid]) {
            return biSearch(arr, left, mid - 1, value);
        } else {
            return biSearch(arr, mid + 1, right, value);
        }

    }
}
