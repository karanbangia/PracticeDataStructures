package com.dynamicProgramming.unboundedKnpasack;

public class P3_CoinChange1 {
//    Coin Change Problem Maximum Number of ways
//    Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//        Example:
//        for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
    public long count(int S[], int m, int n) {
        //code here.
        long dp[][] = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
            {
                if(j>=S[i-1])
                {
                    dp[i][j]=dp[i][j-S[i-1]]+dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
