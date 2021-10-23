package exercise;

import java.util.Arrays;

public class L279 {
    public static void main(String[] args) {
        int res = numSquares(12);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j*j <= n; j++) {
                if (i-j*j>=0) {
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        if (dp[n]==n+1) {
            return -1;
        }

        return dp[n];
    }
}
