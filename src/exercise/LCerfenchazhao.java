package exercise;

public class LCerfenchazhao {
    public static void main(String[] args) {
       int[] nums = {-1,0,3,5,9,12};
       int[] nums2 = {5};
       int res = search(nums2,5);
       System.out.println(res);

    }
    public static int search(int[] nums, int target) {
        return rec(0, nums.length-1, nums,target);
    }

    public static int rec(int left, int right, int[] nums, int target) {
        int mid = (left+right)/2;
        if (left<=right) {
            if (nums[mid]==target) {
                return mid;
            }else if (nums[mid]<target) {
                return rec(mid+1, right, nums, target);
            }else {
                return rec(left,mid-1,nums,target);
            }
        }

        return -1;
    }
}
