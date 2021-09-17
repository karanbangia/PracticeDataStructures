package com.dynamicProgramming.longestCommonSubsequence;

import org.junit.Test;

//https://leetcode.com/problems/shortest-common-supersequence/
public class P8_PrintShortestCommonSupersequence {
    public String shortestCommonSupersequence(String x, String y) {

        String lcs= printLcs(x.length(), y.length(), x, y);

        int i=0;
        int j=0;
        int k=0;
        int n=lcs.length();
        StringBuilder ans=new StringBuilder();
        while (k<lcs.length())
        {
            while (x.charAt(i)!=lcs.charAt(k))
            {
                ans.append(x.charAt(i));
                i++;
            }
            while (y.charAt(j)!=lcs.charAt(k))
            {
                ans.append(y.charAt(j));
                j++;
            }
            ans.append(lcs.charAt(k));
            k++;
            i++;
            j++;
        }
       return ans.append(x.substring(i)).append(y.substring(j)).toString();
    }

    String printLcs(int n, int m, String x, String y) {
        int dp[][] = new int[n + 1][m + 1];
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
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
    public void test() {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
