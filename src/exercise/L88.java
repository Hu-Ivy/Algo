package exercise;

import java.util.Arrays;

public class L88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[m+n];


        int i1=0;
        int i2=0;

        for(int i=0;i<temp.length;i++) {
            if(i1==m) {
                temp[i]=nums2[i2++];

            }else if(i2==nums2.length) {
                temp[i]=nums1[i1++];
            }else if(nums1[i1]<=nums2[i2]) {
                temp[i]=nums1[i1++];
            }else {
                temp[i]=nums2[i2++];
            }

        }

        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }
}
