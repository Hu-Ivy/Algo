package exercise;

import java.util.Arrays;

public class LC912 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] res=sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArray(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            int index=i;
            int min=nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<min) {
                    min=nums[j];
                    index=j;
                }
            }
            swap(nums,i,index);
        }
        return nums;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
