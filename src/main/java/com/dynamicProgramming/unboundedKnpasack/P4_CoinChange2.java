package com.dynamicProgramming.unboundedKnpasack;

import java.io.*;
import java.util.*;

/*https://practice.geeksforgeeks.org/problems/number-of-coins1824/1*/
public class P4_CoinChange2
{

    public int minCoins(int coins[], int M, int V)
    {
        // Your code goes here
        int [][] dp = new int[M+1][V+1];
        //int x = minCoinRecursive(coins,M,V,dp);
        int x = minCoinBottomUp(coins, M, V);
        return x == Integer.MAX_VALUE-1 ? -1 : x;


    }

    int minCoinRecursive(int coins[], int M, int V, int[][] dp){
        if(V == 0) return 0;

        if(M==0 && V != 0) return Integer.MAX_VALUE-1;

        if(dp[M][V] != 0) return dp[M][V];
        if(coins[M-1] <= V){
            dp[M][V] = Math.min((1+minCoinRecursive(coins,M,V-coins[M-1],dp)),
                    (minCoinRecursive(coins,M-1,V,dp)));
            return dp[M][V];
        }
        dp[M][V] = minCoinRecursive(coins,M-1,V,dp);
        return dp[M][V];
    }


    int minCoinBottomUp(int coins[], int M, int V){

        int [][]dp = new int[M+1][V+1];

        for(int i=0;i<=V;i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=0;i<=M;i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=M;i++){
            for(int j=1; j<=V;j++){
                if(coins[i-1] <= j){

                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[M][V];
    }

}