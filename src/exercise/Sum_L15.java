package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_L15 {
    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4};
        int[] nums2= {-1,-1,0,1};
        List<List<Integer>> ans= threeSum(nums2);
        System.out.println(ans.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length<3) return ans;
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if (nums[k]>0) continue;
            int i=k+1;
            int j= nums.length-1;
            if (k>0&&nums[k]==nums[k-1]) {
                continue;
            }

            while (i<j) {
                int s= nums[k]+nums[i]+nums[j];
                if (s>0) {
                    while (i<j&&nums[j]==nums[j-1]) {
                        j--;
                    }
                    j--;
                }else if (s<0) {
                    while (i<j&&nums[i+1]==nums[i]) {
                        i++;
                    }
                    i++;
                }else {
                    ans.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i<j&&(nums[j]==nums[j-1])) {
                        j--;
                    }
                    j--;
                    while (i<j&&(nums[i+1]==nums[i])) {
                        i++;
                    }
                    i++;
                }
            }

        }
        return ans;

    }

}
