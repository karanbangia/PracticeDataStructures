package com.dynamicProgramming.longestCommonSubsequence;


import java.util.Arrays;

public class P1_LongestCommonSubsequence
{

    int lcsRecurice(String x, String y, int n, int m)
    {
        if (n == 0 || m == 0)
            return 0;
        if (x.charAt(n - 1) == y.charAt(m - 1))
            return 1 + lcsRecurice(x, y, n - 1, m - 1);
        else
            return Math.max(lcsRecurice(x, y, n - 1, m), lcsRecurice(x, y, n, m - 1));
    }

    int dp[][];

    int lcsRecuriceMemoize(int n, int m, String x, String y)
    {
        dp = new int[n + 1][m + 1];
        for (int arr[] : dp)
        {
            Arrays.fill(arr, -1);
        }
        return utility(x, y, n, m);
    }

    private int utility(String x, String y, int n, int m)
    {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (x.charAt(n - 1) == y.charAt(m - 1))
            return dp[n][m] = 1 + utility(x, y, n - 1, m - 1);
        else
            return dp[n][m] = Math.max(utility(x, y, n - 1, m), utility(x, y, n, m - 1));
    }

    int lcsBottomUp(int n, int m, String x, String y)
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
