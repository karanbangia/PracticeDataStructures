package com.dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;

public class P2_MaximumSumIncreasingSubsequence
{

    public int maxSumIS(int arr[], int n)
    {
        //code here.
        int dp[]=Arrays.copyOf(arr, n);
        int best=arr[0];
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[i],arr[i]+dp[j]);
                }
            }
            best=Math.max(best,dp[i]);
        }
        return best;
    }
}
