package exercise;

import java.util.Arrays;
import java.util.HashSet;

public class Sort50 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] temp = new int[nums.length];
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(nums));

        int res = solution2(nums);
        System.out.println("result:"+res);
    }

    public static int solution(int[] nums) {
        if (nums==null&&nums.length==0) {
            return -1;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int num :
                nums) {
            if (hs.contains(num)) {
                return num;
            }else  {
                hs.add(num);
            }
        }
        return -1;
    }
    public static int solution2(int[] nums) {
        int[] temp = new int[nums.length];
        for (int num :
                nums) {

            temp[num]++;
            System.out.println(temp[num]);
            if (temp[num]==2) {
                return num;
            }
        }
        return -1;
    }
}
