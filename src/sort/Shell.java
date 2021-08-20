package sort;

import java.util.Arrays;

public class Shell {

    static int[] arr2 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

    public static void main(String[] args) {
//        ShellSort(arr2);
        ShellSort2(arr2);
    }

    public static void ShellSort(int[] arr) {
        for (int i = 5; i < arr.length; i++) {
            for (int j = i-5; j >=0; j-=5) {
                if (arr[j+5]<arr[j]) {
                    int temp=arr[j+5];
                    arr[j+5]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 2; i < arr.length; i++) {
            for (int j = i-2; j >=0; j-=2) {
                if (arr[j+2]<arr[j]) {
                    int temp=arr[j+2];
                    arr[j+2]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0; j-=1) {
                if (arr[j+1]<arr[j]) {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void ShellSortFinal(int[] arr) {
        for (int m = arr.length/2; m >=1; m/=2) {
            for (int i = m; i < arr.length; i++) {
                for (int j = i-m; j >=0; j-=m) {
                    if (arr[j+1]<arr[j]) {
                        int temp=arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void ShellSort2(int[] arr) {
        for (int m = arr.length/2; m >=1; m/=2) {
            for (int i = m; i < arr.length; i++) {
                int insertValue =arr[i];
                int insertIndex = i-m;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + m] = arr[insertIndex];
                    insertIndex-=m;
                }
                arr[insertIndex + m] = insertValue;

            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
