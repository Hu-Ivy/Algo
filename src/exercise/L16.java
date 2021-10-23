package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L16 {
    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = -1;

        int res = threeSumClosest(nums,target);
        System.out.println(res);

    }

    public static int threeSumClosest(int[] nums, int target) {

        int best=10000000;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            while (left<right) {
                int sum = nums[i]+nums[right]+nums[left];
                int min = Math.abs(sum-target);

                if (sum==target) return sum;
                //如果小于之前的差绝对值，则新的值为best。
                if (min<=Math.abs(best-target)) {
                    best = sum;
                }
                //如果sum>target，说明应该减小右指针。
                if (sum>target) {

                    while (left<right&&nums[right]==nums[right-1]) {
                        right--;
                    }
                    right--;
                }else {
                    while (left<right&&nums[left]==nums[left+1]) {
                        left++;
                    }
                    left++;
                }

            }
        }

        return best;
    }
}
