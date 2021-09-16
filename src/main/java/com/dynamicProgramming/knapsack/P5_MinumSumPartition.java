package com.dynamicProgramming.knapsack;

import org.junit.Test;

import java.util.Arrays;

public class P5_MinumSumPartition {

    int sum;
    private int dp[][];
    private boolean booleanDp[][];

    public int minDifferenceTopDown(int arr[], int n) {
        sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
        dp = new int[n + 1][sum + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return utility(n, 0, arr);
    }

    private int utility(int n, int sum, int[] arr) {
        if (n == 0) {
            return Math.abs((this.sum - sum) - sum);
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        return dp[n][sum] = Math.min(utility(n - 1, sum + arr[n - 1], arr), utility(n - 1, sum, arr));
    }

    public int minDifferenceBottomUp(int arr[], int n) {
        int totalSum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
        sum=totalSum/2;
        booleanDp=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                {
                    booleanDp[i][j]=false;
                }
                if(j==0)
                {
                    booleanDp[i][j]=true;
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for (int j=1;j<sum+1;j++)
            {
                if(j>=arr[i-1])
                {
                    booleanDp[i][j]=booleanDp[i-1][j-arr[i-1]] || booleanDp[i-1][j];
                }
                else {
                    booleanDp[i][j]=booleanDp[i-1][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<sum+1;j++)
        {
            if(booleanDp[n][j])
            {
                min=Math.min(totalSum-2*j,min);
            }
        }
        return min;
    }

}
