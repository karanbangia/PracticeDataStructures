package com.dynamicProgramming.matrix;

public class P7_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = dungeon[i][0];
            } else {
                dp[i][0] = dp[i - 1][0] + dungeon[i][0];
            }
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + dungeon[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

            }
        }
        return -1;
    }
}
