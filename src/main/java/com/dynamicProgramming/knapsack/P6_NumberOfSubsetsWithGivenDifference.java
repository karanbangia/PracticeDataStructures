package com.dynamicProgramming.knapsack;

import org.junit.Test;

public class P6_NumberOfSubsetsWithGivenDifference {
    private int dp[][];

    public int numberOfSubsetsWithGivenDifference(int arr[], int n, int diff) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        if (diff > sum) return 0;
        if ((diff + sum) % 2 == 0) {
            dp = new int[n + 1][sum + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    }
                    if (j == 0) {
                        dp[i][j] = 1;
                    }
                }
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    if (j >= arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][sum];
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(numberOfSubsetsWithGivenDifference(new int[]{1, 1, 2, 3}, 4, 1));
    }
}
