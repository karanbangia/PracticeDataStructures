package com.dynamicProgramming.knapsack;

public class P7_TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (Math.abs(S) > sum) return 0;
        return (S + sum) % 2 == 0 ? subsetCount(nums, (S + sum) / 2) : 0;
    }

    private int subsetCount(int[] nums, int S) {
        int n = nums.length;
        int[][] dp = new int[n + 1][S + 1];
        dp[0][0] = 1;
        // first change
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= S; j++) {
                // second change
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][S];
    }


}
