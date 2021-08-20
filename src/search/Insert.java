package search;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1, 2, 3, 4, 5, 6, 7,8,9};
        int index = inseartSearch(arr, 0, arr.length - 1, 8);
        System.out.println(index);
    }

    public static int inseartSearch(int[] arr, int left, int right, int value) {
        int mid;
        mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (left > right | value < arr[left] || value > arr[right]) {
            return -1;
        }
        if (value == arr[mid]) {
            return mid;
        } else if (value < arr[mid]) {
            return inseartSearch(arr, left, mid - 1, value);
        } else {
            return inseartSearch(arr, mid + 1, right, value);
        }
    }
}
