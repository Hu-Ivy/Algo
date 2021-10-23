package exercise;

import java.util.HashMap;

public class L560 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int res = subarraySum2(nums,k);
        System.out.println(res);
    }

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length+1;
        int count = 0;
        
        int[] premium = new int[len];
        premium[0]=0;
        for (int i = 1; i < len; i++) {
            premium[i] = premium[i-1]+nums[i-1];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (premium[j]-premium[i]==k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            //如果之前有存在pre-k值的和，说明pre-此和为剩下值的和也为k。所以count+1。因为只需要计数，所以用map存储之前出现过的和。
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

    }
}
