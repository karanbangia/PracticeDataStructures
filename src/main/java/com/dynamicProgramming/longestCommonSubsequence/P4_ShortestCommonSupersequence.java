package com.dynamicProgramming.longestCommonSubsequence;
//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
public class P4_ShortestCommonSupersequence {
        public static int shortestCommonSupersequence(String x,String y,int n,int m)
        {
            int dp[][] = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= m; j++)
                {
                    if (x.charAt(i - 1) == y.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                    {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return x.length()+y.length()-dp[n][m];
        }
}
