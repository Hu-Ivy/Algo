package search;

import java.util.Arrays;

public class Fibonacci {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = new int[] {1,8,10,89,1000,1000,1234};
        int result = fibonacciSearch(arr,1000);
        System.out.println(result);
    }
    public static int fibonacciSearch(int[] arr, int key) {
        int left=0;
        int right = arr.length-1;
        int k=0;
        int mid=0;
        int f[] = fibo();
        while (right-left>(f[k]-1)) {
            k++;
        }

        int[] temp= Arrays.copyOf(arr,f[k]);
        for (int i = right+1; i < temp.length;i++) {
            temp[i] = temp[right];
        }

        while (left<=right) {
//            将数据分为两部分，
            mid=left+f[k-1]-1;
            if (key<temp[mid]) {
                right=mid-1;
                //f(k-1)=f(k-2)+f(k-3)
                k--;
            }else if (key>temp[mid]) {
                left = mid+1;
                k-=2;
            }else {
                //数组是加长过的，所以要返回不能超过right的值
                return Math.min(mid, right);

            }

        }
        return -1;
    }
    public static int[] fibo() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
}
