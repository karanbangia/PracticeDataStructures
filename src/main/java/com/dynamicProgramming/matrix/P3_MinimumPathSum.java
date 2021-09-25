package com.dynamicProgramming.matrix;

import org.junit.Test;

//https://leetcode.com/problems/minimum-path-sum/
public class P3_MinimumPathSum
{
    public int minPathSum(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                dp[i][0] = grid[i][0];
            }
            else
            {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }
        for (int j = 1; j < m; j++)
        {

            dp[0][j] = dp[0][j - 1] + grid[0][j];

        }
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
    @Test
    public void test()
    {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
