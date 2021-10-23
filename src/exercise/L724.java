package exercise;

public class L724 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int res = pivotIndex(nums);

        System.out.println(res);
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length+1;

        int[] premium = new int[len];
        premium[0]=0;
        for (int i = 1; i < len; i++) {
            premium[i] = premium[i-1]+nums[i-1];
        }
        //减去前面的和判断和前面的和一样吗。
        for (int i = 1; i < len; i++) {
            if (premium[len-1]-premium[i]==premium[i-1]) {
                return i-1;
            }
        }

        return -1;
    }
}
