package exercise;

import java.util.*;

public class L496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] res = nextGreaterElement2(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
    //暴力解题法
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int curVal = nums1[i];
            int j=0;

            while (j< nums2.length&&nums2[j]!=curVal) {
                j++;
            }

            while (j< nums2.length&&nums2[j]<=curVal) {
                j++;
            }
            if (j==nums2.length) {
                res[i]=-1;
            }else {
                res[i]=nums2[j];
            }
        }
        return res;
    }
    //单调栈
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[i]>stack.peek()) {
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(),-1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
