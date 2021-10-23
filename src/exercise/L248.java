package exercise;

import java.util.HashMap;

public class L248 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        int res = numberOfSubarrays(nums, k);
        System.out.println(res);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int pre = 0;
        int count = 0;

        if (len<k) return 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0,1);

        for (int num : nums) {
            if (num % 2 == 1) {
                pre++;

            }

            if (mp.containsKey(pre-k)) {
                count += mp.get(pre-k);
            }
            //每次移动pre出现的记录次数。pre不变时，数量+1；pre增多是，数量+1；如果pre-k存在，说明有mp.get(pre-k)个子数组。
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);

        }
        return count;
    }
}
