package com.dynamicProgramming.longestCommonSubsequence;
//https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
public class P9_LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        return lcsBottomUp(str.length(),str.length(),str,str);

    }
    int lcsBottomUp(int n, int m, String x, String y)
    {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (x.charAt(i - 1) == y.charAt(j - 1) && i!=j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
