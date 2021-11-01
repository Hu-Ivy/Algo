package exercise;

import java.util.Arrays;

public class Backpack {
    public static void main(String[] args) {

    }

    public int backpack01(int W, int[] weights, int[] values) {
        int N = weights.length;
        if (N==0) {
            return 0;
        }

        int[][] dp = new int[N+1][W+1];
        Arrays.fill(dp[0],1);
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]+values[i-1]]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[N][W];
    }
}
