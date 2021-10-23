package exercise;

import java.util.Arrays;

public class L167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target =9;
        int[] res = twoSum(numbers,target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];
        while (left<right) {
            int sum = numbers[right]+numbers[left];
            if (sum>target) {
                right--;
            }else if (sum<target){
                left++;
            }else {
                return new int[]{left,right};
            }
        }
        return res;
    }
}
