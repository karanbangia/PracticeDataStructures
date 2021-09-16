package com.dynamicProgramming.longestCommonSubsequence;

import java.util.Arrays;

public class P2_LongestCommonSubstring
{

    int longestCommonSubstrBottomUp(String S1, String S2, int n, int m)
    {
        // code here
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (S1.charAt(i - 1) == S2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}
