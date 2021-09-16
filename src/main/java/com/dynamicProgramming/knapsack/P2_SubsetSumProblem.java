package com.dynamicProgramming.knapsack;

public class P2_SubsetSumProblem {
    Boolean dp[][];

    Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        dp = new Boolean[N + 1][sum + 1];
        return utility(N, arr, sum);
    }

    Boolean utility(int n, int arr[], int sum) {
        if (n == 0 && sum != 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }
        if (sum >= arr[n - 1]) {
            return dp[n][sum] = utility(n - 1, arr, sum - arr[n - 1]) || utility(n - 1, arr, sum);
        } else {
            return dp[n][sum] = utility(n - 1, arr, sum);
        }
    }
}
