package exercise;

import java.util.Arrays;

public class L322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 11;
        int res = coinChange(coins,amount);
        System.out.println(res);
    }

    public static int coinChange(int[] coins, int amount) {

        int[] status = new int[amount+1];
        Arrays.fill(status,amount+1);
        status[0] = 0;
        for (int i = 1; i < status.length; i++) {
            //将最小数量值转移给i，如果没有则为amount+1；
            for (int coin :
                    coins) {
                //大于0，且前一个状态不为amount+1
                if (i-coin>=0&&status[i-coin]!=amount+1) {
                    status[i]= Math.min(status[i], status[i-coin]+1);
                }
            }

        }

        //如果最后没有比能传递过去的最优解，则返回-1；
        if (status[amount]==amount+1) {
            return -1;
        }
        return status[amount];
    }
}
