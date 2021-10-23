package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};


        List<List<Integer>> res = threeSumClosest(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> threeSumClosest(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;

            if (nums.length<3) {
                return res;
            }

            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            while (left<right) {
                int sum = nums[right]+nums[left];
                if (sum>target) {
                    right--;
                    while (nums[right]==nums[right+1]) {
                        right--;
                    }
                }else if (sum<target){
                    left++;
                    while (nums[left]==nums[left-1]) {
                        left++;
                    }

                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left++]);
                    temp.add(nums[right--]);
                    res.add(temp);
                    while (nums[right]==nums[right+1]) {
                        right--;
                    }
                    while (nums[left]==nums[left-1]) {
                        left++;
                    }
                }

            }
        }

        return res;
    }
}
