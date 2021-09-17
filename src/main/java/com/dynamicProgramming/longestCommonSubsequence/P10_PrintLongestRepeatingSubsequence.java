package com.dynamicProgramming.longestCommonSubsequence;

import org.junit.Test;

public class P10_PrintLongestRepeatingSubsequence {
    public String LongestRepeatingSubsequence(String str) {
        // code here
        return lcsBottomUp(str.length(), str.length(), str, str);

    }

    String lcsBottomUp(int n, int m, String x, String y) {
        int dp[][] = new int[n + 1][m + 1];
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1) && i!=j) {
                ans.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

        }
        return ans.reverse().toString();
    }
    @Test
    public void test()
    {
        System.out.println(LongestRepeatingSubsequence("xxx"));
    }
}
