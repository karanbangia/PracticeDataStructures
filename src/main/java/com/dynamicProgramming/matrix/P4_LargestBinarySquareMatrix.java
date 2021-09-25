package com.dynamicProgramming.matrix;

public class P4_LargestBinarySquareMatrix
{
    public int maximalSquare(char[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int largest=0;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j< m; j++)
            {
                if(matrix[i][j]=='1')
                {
                    dp[i][j]=Character.getNumericValue(matrix[i][j]);
                    largest=1;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            for (int j=1;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
                largest=Math.max(largest,dp[i][j]);
            }
        }
        return largest*largest;
    }
}
