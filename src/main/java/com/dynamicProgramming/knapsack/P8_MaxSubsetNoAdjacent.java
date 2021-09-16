package com.dynamicProgramming.knapsack;

import java.util.Arrays;

public class P8_MaxSubsetNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        int[][] dp = new int[array.length + 1][totalSum];
        for (int x[] : dp) {
            Arrays.fill(x, -1);
        }
        return utility(array, array.length, 0, array.length + 2, dp);
    }

    private static int utility(int[] array, int n, int sum, int last, int[][] dp) {
        if (n == 0) {
            return sum;
        }
        if (last == n) {
            return dp[n][sum] = utility(array, n - 1, sum, last, dp);
        } else
            return dp[n][sum] = Math.max(utility(array, n - 1, sum + array[n - 1], n - 1, dp), utility(array, n - 1, sum, last, dp));
    }
}
