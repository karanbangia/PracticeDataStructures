package com.dynamicProgramming.unboundedKnpasack;

import java.util.ArrayList;

public class P2_RodCutting {
    public int rodCut(int A, ArrayList<Integer> B) {
        int dp[][] = new int[B.size() + 1][A + 1];
        for (int i = 1; i <= B.size(); i++) {
            for (int j = 1; j <= A; j++) {
                if (j >= B.get(i - 1))
                    dp[i][j] = Math.max(1 + dp[i][j - B.get(i - 1)], dp[i][j - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[B.size()][A];
    }
}
