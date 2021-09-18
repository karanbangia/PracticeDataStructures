package com.dynamicProgramming.leetCode;

import java.util.Arrays;

public class P3_EditDistance
{
    int dp[][];

    public int minDistance(String word1, String word2)
    {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int x[] : dp)
        {
            Arrays.fill(x, -1);
        }
        return solve(word1, word2, word1.length(), word2.length());
    }

    private int solve(String s1, String s2, int n, int m)
    {
        if (n == 0)
        {
            return m;
            //jitti bcchi hui string
        }
        if (m == 0)
        {
            return n;
        }
        if (dp[n][m] != -1)
        {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1))
        {
            return dp[n][m] = solve(s1, s2, n - 1, m - 1);
            //no operation performed
        }
        else
            return dp[n][m] = 1 + Math.min(
                    solve(s1, s2, n - 1, m),
                    //remove string
                    Math.min(solve(s1, s2, n, m - 1),
                            //insert string
                            solve(s1, s2, n - 1, m - 1)));
                                //replace string
    }
}
