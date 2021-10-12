package tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,6,8,5,9,10,12,7,2,1,0};
        heapSort(arr);

    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
        int temp;
        //
        for (int i = arr.length/2-1; i >=0 ; i--) {
            ajustHeap(arr,i,arr.length-1);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length-1; i >0 ; i--) {
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            ajustHeap(arr,0, i);
            System.out.println(i+"***********");
            System.out.println(Arrays.toString(arr));
        }

    }

    /**大数放根节点，被换的节点仍然往下比较
     *
     * @param arr 待调整数组
     * @param i 非叶子结点的索引
     * @param length    对多少个元素继续调整，length逐渐减少
     */
    public static void ajustHeap(int[] arr, int i, int length) {
        int temp=arr[i];
        //开始调整,找到最大值并换到合适的位置.
        for (int k = i*2+1; k < length; k=k*2+1) {
            if (k+1<length&&arr[k]<arr[k+1]) {
                k++;//k指向右节点
            }
            //如果根节点比子节点大
            if (arr[k]>temp) {
                arr[i]=arr[k];
                i=k;//继续循环比较

            }else {
                break;
            }
        }
        //循环结束，i已经是子树的最大值了
        arr[i]=temp;
    }
}
