package com.dynamicProgramming.algoExpert;

import java.util.Arrays;

public class P2_MinimumNumberOfJumps
{
    public static int minNumberOfJumps(int[] arr)
    {
        // Write your code here.
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] + j >= i)
                {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}
