package com.dynamicProgramming.knapsack;

import java.util.Arrays;

public class P1_ZeroOneKnapSack {
    int dp[][];
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSackTopDown(int W, int wt[], int val[], int n) {
        dp = new int[W + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return utility(W, wt, val, n);
    }

    int utility(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[W][n] != -1) {
            return dp[W][n];
        }
        if (wt[n - 1] <= W) {
            return dp[W][n] = Math.max(val[n - 1] + utility(W - wt[n - 1], wt, val, n - 1), utility(W, wt, val, n - 1));
        }
        return dp[W][n] = utility(W, wt, val, n - 1);
    }


}
