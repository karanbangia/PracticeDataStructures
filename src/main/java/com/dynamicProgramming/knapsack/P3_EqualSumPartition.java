package com.dynamicProgramming.knapsack;

import java.util.Arrays;

public class P3_EqualSumPartition {
    private boolean dp[][];

    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).reduce(0,(a,b)->a+b);
        if(sum%2!=0)return false;
        sum=sum/2;
        int n=nums.length;
        dp=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                {
                    dp[i][j]=false;
                }
                if(j==0)
                {
                    dp[i][j]=true;
                }
            }
        }
        return subsetSumTopDown(n,nums,sum);
    }

    private boolean subsetSumTopDown(int n, int[] nums, int sum) {
        for(int i=1;i<n+1;i++)
        {
            for (int j=1;j<sum+1;j++)
            {
                if(j>=nums[i-1])
                {
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
