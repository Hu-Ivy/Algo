package exercise;

import java.util.Arrays;

public class L121 {
    public static void main(String[] args) {
        int[] prices = {2,3,1,1,4};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        int res = maxProfit(prices);
//        int res = arrayPairSum(prices);

//        int res = jump(prices);

        int res = compress(chars);
        System.out.println(res);

    }


    //其实是动态规划。
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];

        }
        return sum;
    }
    //L135
    public static int candy(int[] ratings) {
        int len = ratings.length;
        if (len==0) return 0;
        int res = 1;
        int up = 1;
        int down = 0;
        int pre = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i]>ratings[i-1]) {
                up++;
                down=0;
                pre = up;
                res = res + up;

            }else if (ratings[i]==ratings[i-1]) {
                up=1;
                pre=1;
                down=0;
                res = res + 1;
            }else {
                up=1;
                down++;
                if (down>=pre) {
                    res = res + down +1;
                    pre++;
                }else {
                    res = res + down;
                }
            }
        }
        return res;
    }
    //L55跳跃游戏
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len==1) return true;

        int maxReach = 0;
        for (int i = 0; i < len - 1; i++) {
            if (i>maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i+nums[i]);
            if (maxReach>=len) {
                return true;
            }
        }

        return false;

    }
    //L55跳跃游戏 2
    public static int jump(int[] nums) {
        int len = nums.length;
        int times=0;

        int curMax = 0;
        int nextMax = 0;
        for (int i = 0; i < len - 1; i++) {
            nextMax = Math.max(nextMax, nums[i]+i);
            if (i==curMax) {
                curMax = nextMax;
                times++;
            }
        }

        return times;
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;

    }
    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
