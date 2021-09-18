package com.dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;

public class P1_LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] arr)
    {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int best = 1;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
