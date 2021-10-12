package binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,9,100};
        int index = binarySearch(arr,9);
        System.out.println(index);
    }

    public static int binarySearch(int[] array, int target) {
        int left=0;
        int right = array.length-1;

        while (left<=right) {
            int mid= (left+right)/2;
            if (array[mid]==target) {
                return mid;
            }else if (array[mid]<target) {
                left=mid+1;
            }else {
                right=right-1;
            }
        }
        return -1;
    }
}
