package sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[] {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left<right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left,mid,right,temp);
        }

    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //先将左右两边的数据按照规则填充到temp
        while (i <= mid && j <= right) {
            if (arr[i]<=arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        //将剩余部分填充到temp
        while (i<=mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j<=right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //拷贝temp到arr去
        t=0;
        int tempLeft = left;
        while (tempLeft<=right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
