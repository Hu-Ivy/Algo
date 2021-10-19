package exercise;

public class L35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        if(target>nums[right]) return right+1;
        if(target<nums[0]) return 0;

        while(left<=right) {
            int mid = left+(right-left)/2;
            if(target==nums[mid]) {
                return mid;
            }else if (target<nums[mid]) {
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
