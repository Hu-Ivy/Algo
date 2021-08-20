package search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 11, -1, 34, 89};
        int index= search(arr,9);
        System.out.println(index);
    }

    //线性查找是逐一比对
    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value) {
                return i;
            }
        }
        return -1;
    }

}
