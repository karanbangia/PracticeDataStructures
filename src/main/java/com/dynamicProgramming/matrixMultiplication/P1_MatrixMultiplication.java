package com.dynamicProgramming.matrixMultiplication;

import java.util.Arrays;

public class P1_MatrixMultiplication {
    static int matrixMultiplication(int N, int arr[]) {
        int dp[][]=new int[N+1][N+1];
        for(int []x:dp)
        {
            Arrays.fill(x,-1);
        }
        return solve(arr,1,N-1,dp);

    }

    private static int solve(int[] arr, int i, int j, int[][] dp) {
        if(i>=j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int mn=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int tempAns=solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
           mn=Math.min(mn,tempAns);
        }
        return dp[i][j]=mn;
    }
}
