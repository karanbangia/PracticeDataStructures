package com.dynamicProgramming.knapsack;

public class P4_CountOfSubsetSumWithGivenSum {
    private int dp[][];

    public int perfectSum(int arr[], int n, int sum) {
        dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for (int j=1;j<sum+1;j++)
            {
                if(j>=arr[i-1])
                {
                    dp[i][j]=(dp[i-1][j-arr[i-1]]%1000000007  + dp[i-1][j]%1000000007)%1000000007;
                }
                else {
                    dp[i][j]=dp[i-1][j]%1000000007;
                }
            }
        }
        return dp[n][sum];
    }


}
