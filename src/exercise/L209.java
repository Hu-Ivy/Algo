package exercise;

public class L209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int res = minSubArrayLen(target,nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length+1;
        int left=0;
        int right=0;
        int sum=0;
        while (right< nums.length) {
            if (sum<target) {
                sum+=nums[right];

            }
            right++;

            while (sum>=target) {
                if (right-left<minLen) {
                    minLen=right-left;
                }
                sum-=nums[left];
                left++;
            }
        }
        return minLen== nums.length+1?0:minLen;
    }
}
