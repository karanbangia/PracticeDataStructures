package com.dynamicProgramming.longestCommonSubsequence;
//https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
public class P7_MinNumberOfDeletiontoMakeAPalindrome {

    static int minimumNumberOfDeletions(String x) {
        String y=new StringBuilder(x).reverse().toString();
        return y.length()-lcsBottomUp(x.length(),y.length(),x,y);
    }
    static int lcsBottomUp(int n, int m, String x, String y)
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
        return dp[n][m];
    }
}
