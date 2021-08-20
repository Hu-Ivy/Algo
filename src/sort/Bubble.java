package sort;

public class Bubble {

    static int[] arr = {3, 9, -1, 10, -2};
    static int[] arr2 = {1,3,2,4,5};
    static int maxSize = arr.length;
    public static void main(String[] args) {

        while (maxSize!=1) {
            int count = bubbleSort(arr2);
            if (count==0) {
                break;
            }
            maxSize--;
        }


        for (int i :
                arr2) {
            System.out.println(i);
        }
    }

    public static int bubbleSort(int[] arr) {
        int temp;
        int count=0;
        for (int i = 0; i < maxSize-1; i++) {
            if (arr[i]>arr[i+1]) {
                temp = arr[i];
                arr[i]= arr[i+1];
                arr[i+1]= temp;
                count++;
            }

        }
        return count;
    }
}
